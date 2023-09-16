package by.it.restjwt.mapper;

import by.it.restjwt.dto.BookDto;
import by.it.restjwt.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    BookDto convertToDto(Book book);

    Book convertToDomain(BookDto bookDto);
}
