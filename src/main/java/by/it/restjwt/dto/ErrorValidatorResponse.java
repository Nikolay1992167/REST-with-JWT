package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ErrorValidatorResponse extends BaseResponse{

    @Schema(description = "List of validation errors", example = "[\"The 'author' field is required\", \"Some validation errors\"]")
    private List<String> error;
    @Schema(description = "Error validation message", example = "Some validation exception.")
    private String message;


    public ErrorValidatorResponse(HttpStatus status, List<String> error, String message) {
        super(status.value());
        this.error = error;
        this.message = message;
    }
}
