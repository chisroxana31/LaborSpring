package Controller;

import Domain.Book;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Component
public class BookEvent extends ApplicationEvent {

    public BookEvent(Book source) {
        super(source);
    }
}
