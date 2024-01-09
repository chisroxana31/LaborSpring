package Service;

import Controller.BookEvent;
import Domain.Book;
import Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationEventPublisher bookEventPublisher;


    public void addBook(Book book) {
        bookRepository.save(book);
        bookEventPublisher.publishEvent(new BookEvent(book));
    }


    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }


    public Book findBookByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }


    public void removeBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }


    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }
}
