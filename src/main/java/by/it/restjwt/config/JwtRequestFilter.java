package by.it.restjwt.config;

import by.it.restjwt.token.JwtTokenManager;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtTokenManager jwtTokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(AUTHORIZATION);
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String jwt = authorization.substring(7);
            try {
                String username = jwtTokenManager.getUsername(jwt);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            jwtTokenManager.getUserRoles(jwt).stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .toList()
                    );
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            } catch (MalformedJwtException exception) {
                log.debug(exception.getMessage());
            } catch (ExpiredJwtException exception) {
                log.debug(exception.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }
}
