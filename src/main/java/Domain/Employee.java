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
@Table(name = "Employee")
/*Aici trebuie modificat in functie de numele tabelului din baza de date*/
public class Employee implements Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEmployee;
    public String Name;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Librarian librarian;

    public Employee(int idEmployee, String name) {
        this.idEmployee = idEmployee;
        this.Name = name;
    }


    public int getIdEmployee() {
        return idEmployee;
    }


    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setLibrary(Library library) {
        this.library = library;
        if (!library.getEmployees().contains(this)) {
            library.addEmployee(this);
        }
    }
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
