package Controller;

import Controller.BookEvent;
import Domain.Book;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookAddedListener {

    @EventListener
    public void handleBookAddedEvent(BookEvent event) {
        // Handle the event, perform necessary actions
        Book addedBook = (Book) event.getSource();

        // Access book information
        String title = addedBook.getTitle();
        Long id = addedBook.getId();

        // Perform actions based on the added book
        System.out.println("New book added with title: " + title + ", id: " + id);
        // Add your custom logic here
    }
}
