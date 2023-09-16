package by.it.restjwt.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import static by.it.restjwt.utils.Constants.AUTHOR_PATTERN;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookDto extends BaseDto {
    @NotBlank(message = "Enter author")
    @Pattern(regexp = AUTHOR_PATTERN, message = "Incorrect author's name!")
    private String author;
    @NotBlank(message = "Enter title")
    private String title;
}
