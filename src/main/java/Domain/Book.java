package Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "bookauthor",
            joinColumns = @JoinColumn(name = "idbook"),
            inverseJoinColumns = @JoinColumn(name = "idauthor")
    )
    private List<Author> authors = new ArrayList<>();

    @Override
    public String toString() {
        return "Domain.Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", BookId=" + BookId +
                '}';
    }


    private int BookId;

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void printAuthors() {
        for (Author author : authors) {
            System.out.println(author.getName());
        }
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "book_events",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "events_id")
    )
    private List<Events> events = new ArrayList<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.addBook(this);
    }


    public void addEvents(Events event) {
        events.add(event);
        event.addBook(this);
    }

    public List<Genre> getGenres() {
        return genres;
    }

}
