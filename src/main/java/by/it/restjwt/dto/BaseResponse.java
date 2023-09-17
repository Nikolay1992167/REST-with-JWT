package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class BaseResponse {

    @Schema(description = "Status", example = "200")
    private Integer status;
    @Schema(description = "Timestamp", example = "2023-09-17")
    private final LocalDate timestamp = LocalDate.now();
}
