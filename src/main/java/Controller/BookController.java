package Controller;

import Domain.Book;
import Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationEventPublisher bookEventPublisher;

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {

        bookRepository.save(book);
        bookEventPublisher.publishEvent(new BookEvent(book));
    }

    @GetMapping("/printAll")
    public void printAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> System.out.println(book.toString()));
    }

 //   @GetMapping("/findByTitle/{title}")
//    public Book findBookByTitle(@PathVariable String title) {
//        return bookRepository.findByTitleIgnoreCase(title);
//    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @DeleteMapping("/remove/{bookId}")
    public void removeBook(@PathVariable Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @GetMapping("/getById/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    //update
}
