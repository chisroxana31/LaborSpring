package Domain;

import jakarta.persistence.*;

@Entity
public class Librarian implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idLibrarian;
    private String name;

    @OneToOne
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    private static Librarian instance; // Singleton instance
    // Private constructor to prevent direct instantiation
    private Librarian(String name) {
        this.name = name;
    }

    public Librarian() {

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
}
