package Controller;
import org.springframework.context.ApplicationEvent;

public class BookEvent extends ApplicationEvent {

    public BookEvent(Object source) {
        super(source);
    }
}
