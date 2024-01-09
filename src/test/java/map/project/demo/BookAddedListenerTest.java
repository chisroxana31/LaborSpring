package map.project.demo;

import Controller.BookAddedListener;
import Controller.BookEvent;
import Controller.BookEventPublisher;
import Domain.Book;
import Service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class BookAddedListenerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private BookEventPublisher bookEventPublisher;

    @Autowired
    private BookAddedListener bookAddedListener;

    @Captor
    private ArgumentCaptor<BookEvent> bookEventArgumentCaptor;
    @MockBean
    private BookService bookService;

    @Test
    public void testHandleBookAddedEvent() throws Exception {

        Book newBook = new Book();
        newBook.setTitle("Test Book");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/book/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Test Book\"}")) // Use JSON content directly
                .andExpect(status().isOk());

        // Verify that the bookService.addBook method was called with any Book
        Mockito.verify(bookService, Mockito.times(1)).addBook(Mockito.any(Book.class));

        bookEventPublisher.publishEvent(new BookEvent(newBook));


        Mockito.verify(eventPublisher, Mockito.times(1)).publishEvent(bookEventArgumentCaptor.capture());


        BookEvent capturedBookEvent = bookEventArgumentCaptor.getValue();


        bookAddedListener.handleBookAddedEvent(capturedBookEvent);


    }

}