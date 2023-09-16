package by.it.restjwt.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ErrorValidatorResponse extends BaseResponse{

    private List<String> error;
    private String message;


    public ErrorValidatorResponse(HttpStatus status, List<String> error, String message) {
        super(status.value());
        this.error = error;
        this.message = message;
    }
}
