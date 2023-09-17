package by.it.restjwt.dto;

import by.it.restjwt.validator.PasswordMatching;
import by.it.restjwt.validator.UserExist;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static by.it.restjwt.utils.Constants.*;

@Getter
@Setter
@PasswordMatching
@Valid
@Schema(description = "Entity of User")
public class UserRegistrationDto {
    @NotBlank(message = USERNAME_NOT_BLANK)
    @Pattern(regexp = USERNAME_PATTERN, message = "Incorrect username")
    @UserExist
    @Schema(description = "Username", example = "Victor")
    private String username;
    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect password")
    @Schema(description = "Password", example = "rotciv")
    private String password;
    @Pattern(regexp = PASSWORD_PATTERN, message = "Incorrect verify password")
    @NotBlank(message = "Enter verify password")
    @Schema(description = "Password", example = "rotciv")
    private String verifyPassword;
}
