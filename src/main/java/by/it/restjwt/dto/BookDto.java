package by.it.restjwt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import static by.it.restjwt.utils.Constants.AUTHOR_PATTERN;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Entity of Book.")
public class BookDto extends BaseDto {
    @NotBlank(message = "Enter author")
    @Pattern(regexp = AUTHOR_PATTERN, message = "Incorrect author's name!")
    @Schema(description = "Author", example = "Stephen KIng")
    private String author;
    @NotBlank(message = "Enter title")
    @Schema(description = "Title", example = "The Dark Tower")
    private String title;
}
