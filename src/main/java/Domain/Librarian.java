package Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "librarian")

public class Librarian implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibrarian;
    private String name;

    @Getter
    @OneToOne
    @JoinColumn(name = "library_id")
    private Library library;



    @Getter
    private static Librarian instance; // Singleton instance
    // Private constructor to prevent direct instantiation
    private Librarian(String name) {
        this.name = name;
    }



//    private Library library;
    // Singleton getInstance method
    public static Librarian getInstance(String name) {
        if (instance == null) {
            instance = new Librarian(name);
        }
        return instance;
    }

//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }

    public static void reset() {
        instance = null;
    }
    @Override
    public String getName() {
        return name;
    }


    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(int idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public static void setInstance(Librarian instance) {
        Librarian.instance = instance;
    }
}
