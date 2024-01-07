package Controller;

import Controller.BookEvent;
import Domain.Book;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookAddedListener {

    @EventListener
    public void handleBookAddedEvent(BookEvent event) {
        Book addedBook = (Book) event.getSource();

        String title = addedBook.getTitle();
        Long id = addedBook.getId();

        System.out.println("New book added with title: " + title + ", id: " + id);
    }
}
