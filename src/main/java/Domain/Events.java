package Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Events")

public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "events")
//    private List<Book> books = new ArrayList<>();



    public Events(String name) {
        this.name = name;
    }

    // Getter, setter, and other methods...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Book> getBooks() {
//        return books;
//    }

//    public void addBook(Book book) {
//        books.add(book);
//        book.addEvents(this); // Ensure bidirectional relationship
//    }
}
