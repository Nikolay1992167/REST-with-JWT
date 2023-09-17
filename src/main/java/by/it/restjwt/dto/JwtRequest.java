package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import static by.it.restjwt.utils.Constants.PASSWORD_NOT_BLANK;
import static by.it.restjwt.utils.Constants.USERNAME_NOT_BLANK;

@Data
@Schema(description = "Entity of User.")
public class JwtRequest {

    @NotBlank(message = USERNAME_NOT_BLANK)
    @Schema(description = "Username", example = "Victor")
    private String username;
    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Schema(description = "Password", example = "rotciv")
    private String password;
}
