package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    @Schema(description = "Jwt-token", example = "XXX.YYYY.ZZZZ")
    private String token;
}
