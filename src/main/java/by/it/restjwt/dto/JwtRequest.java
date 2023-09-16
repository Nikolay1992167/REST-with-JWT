package by.it.restjwt.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static by.it.restjwt.utils.Constants.PASSWORD_NOT_BLANK;
import static by.it.restjwt.utils.Constants.USERNAME_NOT_BLANK;

@Data
public class JwtRequest {
    @NotBlank(message = USERNAME_NOT_BLANK)
    private String username;
    @NotBlank(message = PASSWORD_NOT_BLANK)
    private String password;
}
