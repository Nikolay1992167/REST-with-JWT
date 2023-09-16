package by.it.restjwt.controller;

import by.it.restjwt.dto.BaseResponse;
import by.it.restjwt.dto.JwtRequest;
import by.it.restjwt.dto.JwtResponse;
import by.it.restjwt.dto.UserRegistrationDto;
import by.it.restjwt.service.AuthService;
import by.it.restjwt.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static by.it.restjwt.utils.Constants.USER;
import static by.it.restjwt.utils.ResponseUtils.CREATION_MESSAGE;
import static by.it.restjwt.utils.ResponseUtils.getSuccessResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody @Valid JwtRequest request) throws BadCredentialsException {
        String token = authService.getToken(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<BaseResponse> createNewUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, USER));
    }
}
