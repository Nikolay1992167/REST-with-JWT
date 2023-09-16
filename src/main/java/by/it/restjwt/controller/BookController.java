package by.it.restjwt.controller;

import by.it.restjwt.dto.BaseResponse;
import by.it.restjwt.dto.BookDto;
import by.it.restjwt.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.it.restjwt.utils.ResponseUtils.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponse>create(@RequestBody BookDto bookDto){
        bookService.save(bookDto);
        return ResponseEntity.ok(getSuccessResponse(CREATION_MESSAGE, "Book"));
    }

    @PatchMapping("{id}")
    public ResponseEntity<BaseResponse>Update(@PathVariable("id") Long id, @RequestBody BookDto bookDto){
        bookService.update(id, bookDto);
        return ResponseEntity.ok(getSuccessResponse(UPDATE_MESSAGE, "Book"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable("id") Long id){
        bookService.delete(id);
        return ResponseEntity.ok(getSuccessResponse(DELETE_MESSAGE, "Book"));
    }
}
