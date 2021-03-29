package am.itspace.rest.endpoint;


import am.itspace.common.exception.ResourceNotFoundException;
import am.itspace.common.model.Book;
import am.itspace.common.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookRepo bookRepo;

    @GetMapping("/books")
    public List<Book> books() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist"));
    }
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        if (book.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        return bookRepo.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book book, @PathVariable("id") int id) throws ResourceNotFoundException {
        Book bookFromDB = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist"));
        bookFromDB.setTitle(book.getTitle());
        bookFromDB.setDescription(book.getDescription());
        bookFromDB.setPrice(book.getPrice());
        return bookRepo.save(bookFromDB);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") int id) throws Throwable {
        bookRepo.delete(bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist")));
    }
}
