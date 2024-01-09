package Controller;

import Controller.BookEvent;
import Domain.Book;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public BookEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Component
    public class BookEvent extends ApplicationEvent {

        public BookEvent(Book source) {
            super(source);
        }
    }
}
