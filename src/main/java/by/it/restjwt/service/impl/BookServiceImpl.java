package by.it.restjwt.service.impl;

import by.it.restjwt.dto.BookDto;
import by.it.restjwt.entity.Book;
import by.it.restjwt.exception.BookNotFoundException;
import by.it.restjwt.mapper.BookMapper;
import by.it.restjwt.repository.BookRepository;
import by.it.restjwt.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.it.restjwt.utils.ObjectUtils.getIgnoreProperties;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::convertToDto)
                .toList();
    }

    @Override
    public BookDto getBook(Long id) {
        return bookMapper.convertToDto(bookRepository.getReferenceById(id));
    }

    @Override
    public void save(BookDto bookDto) {
        bookRepository.save(bookMapper.convertToDomain(bookDto));
    }

    @Override
    public void update(Long id, BookDto bookDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Book updateBook = bookMapper.convertToDomain(bookDto);
            BeanUtils.copyProperties(updateBook, book, getIgnoreProperties(updateBook, "id"));
        } else {
            throw new BookNotFoundException();
        }
    }

    @Override
    public void delete(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException();
        }
    }
}
