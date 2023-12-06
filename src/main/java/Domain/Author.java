package Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
public class Author implements Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "Author")
    private List<Book> books = new ArrayList<>();

    public Author() {

    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Domain.Author{" +
                "name='" + name + '\'' +
                ", AuthorId=" + AuthorId +
                '}';
    }

    private int AuthorId;

    public int getAuthorId() {
        return AuthorId;
    }

    public Author(String name){
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    public void writeBook(Book book){
        book.addAuthor(this);
    }

    public void setAuthorId(int authorIdCounter) {
        this.AuthorId = authorIdCounter;
    }
}
