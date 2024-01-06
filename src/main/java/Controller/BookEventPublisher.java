package Controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BookEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public BookEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishBookAddedEvent() {
        BookEvent bookEvent = new BookEvent(this);
        eventPublisher.publishEvent(bookEvent);
    }
}
