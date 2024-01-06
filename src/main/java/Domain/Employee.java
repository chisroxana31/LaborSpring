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
@Table(name = "employee")
/*Aici trebuie modificat in functie de numele tabelului din baza de date*/
public class Employee implements Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Librarian librarian;

    public Employee(int idEmployee, String name) {
        this.id = idEmployee;
        this.name = name;
    }


    public int getIdEmployee() {
        return id;
    }


    public void setIdEmployee(int idEmployee) {
        this.id = idEmployee;
    }

    public void setName(String Name) {
        name = Name;
    }

    @Override
    public String getName() {
        return name;
    }



    //    public void setLibrary(Library library) {
//        this.library = library;
//        if (!library.getEmployees().contains(this)) {
//            library.addEmployee(this);
//        }
//    }
    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
        if (librarian != null) {
            librarian.setEmployee(this);
        }
    }
}