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
//@AllArgsConstructor
@Setter
@Getter
@Table(name = "Genre")

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private String name;

//    @ManyToMany(mappedBy = "genres")
//    private List<Book> books = new ArrayList<>();


//    public Genre(String name) {
//        this.name = name;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public List<Book> getBooks() {
//        return books;
//    }

//    public void addBook(Book book) {
//        books.add(book);
////        book.getGenres().add(this);
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
}
