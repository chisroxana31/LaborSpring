package Controller;

import Domain.Book;
import Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@ComponentScan({"Controller", "Patterns.Observer", "Domain"})
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    private final BookEventPublisher bookEventPublisher;

    @Autowired
    public BookController(BookRepository bookRepository, BookEventPublisher bookEventPublisher) {
        this.bookRepository = bookRepository;
        this.bookEventPublisher = bookEventPublisher;
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        // Save the book to the repository
        Book savedBook = bookRepository.save(book);

        // Publish the event that a new book has been added
        bookEventPublisher.publishBookAddedEvent();

        return "Book added successfully!";
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
