package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static by.it.restjwt.utils.Constants.ROLE_USER;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Entity of User")
public class UserDto extends BaseDto{

    @Schema(description = "Username", example = "Nikolay")
    private String username;
    @Schema(description = "User's role", example = ROLE_USER)
    private String role;
}
