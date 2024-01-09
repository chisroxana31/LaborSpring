package Controller;

import Domain.Book;
import Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/printAll")
    public void printAllBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(book -> System.out.println(book.toString()));
    }

    @GetMapping("/findByTitle/{title}")
    public Book findBookByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/remove/{bookId}")
    public void removeBook(@PathVariable Long bookId) {
        bookService.removeBook(bookId);
    }

    @GetMapping("/getById/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/update/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        return bookService.updateBook(bookId, updatedBook);
    }
}