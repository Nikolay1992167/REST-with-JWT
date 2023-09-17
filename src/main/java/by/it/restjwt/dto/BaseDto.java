package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class BaseDto {

    @Schema(description = "Identifier", example = "1")
    @Min(1)
    private Long id;
}
