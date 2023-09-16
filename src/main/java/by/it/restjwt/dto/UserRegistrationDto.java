package by.it.restjwt.dto;

import by.it.restjwt.validator.PasswordMatching;
import by.it.restjwt.validator.UserExist;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static by.it.restjwt.utils.Constants.*;

@Getter
@Setter
@PasswordMatching
@Valid
public class UserRegistrationDto {
    @NotBlank(message = USERNAME_NOT_BLANK)
    @Pattern(regexp = USERNAME_PATTERN, message = "Incorrect username")
    @UserExist
    private String username;
    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect password")
    private String password;
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect verify password")
    @NotBlank(message = "Enter verify password")
    private String verifyPassword;
}
