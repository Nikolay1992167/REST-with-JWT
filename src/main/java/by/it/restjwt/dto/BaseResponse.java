package by.it.restjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public abstract class BaseResponse {

    private Integer status;
    private final LocalDate timestamp = LocalDate.now();
}
