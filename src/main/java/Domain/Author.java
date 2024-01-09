package Domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "bookauthor",
            joinColumns = @JoinColumn(name = "idauthor"),
            inverseJoinColumns = @JoinColumn(name = "idbook")
    )
    private List<Book> books = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    public long getAuthorId() {
//        return id;
//    }

    public Author(String name){
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }


}
