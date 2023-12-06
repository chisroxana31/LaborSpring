package Domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee implements Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEmployee;
    public String Name;

    public Employee(int idEmployee, String name) {
        this.idEmployee = idEmployee;
        this.Name = name;
    }

    public Employee() {
        //default constructor for JPA
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
}
