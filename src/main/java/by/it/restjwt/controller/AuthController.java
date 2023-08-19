package by.it.restjwt.controller;

import by.it.restjwt.dto.JwtRequest;
import by.it.restjwt.dto.JwtResponse;
import by.it.restjwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody JwtRequest request){
        String token = authService.getToken(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
