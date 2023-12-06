package Domain;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Genre {
    private List<Book> books = new ArrayList<>();

    public Genre(String name) {
    }


    public void addBook(Book book) {
        books.add(book);
        //book.addGenre(this);


    }
}
