package by.it.restjwt.service;

import by.it.restjwt.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();
    BookDto getBook(Long id);
    void save(BookDto bookDto);
    void update(Long id, BookDto bookDto);
    void delete(Long id);
}
