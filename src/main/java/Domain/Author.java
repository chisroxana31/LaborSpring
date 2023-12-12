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
@Table(name = "author")
public class Author implements Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "Author")
//    private List<Book> books = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }




    //private int AuthorId;

    public long getAuthorId() {
        return id;
    }

    public Author(String name){
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

//    public void writeBook(Book book){
//        book.addAuthor(this);
//    }

//    public void setAuthorId(int authorIdCounter) {
//        this.AuthorId = authorIdCounter;
//    }
}
