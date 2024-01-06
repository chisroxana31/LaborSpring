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
@Table(name = "customer")
/*Aici trebuie modificat in functie de numele tabelului din baza de date*/
public class Customer implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + Name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public String getName() {
        return Name;
    }

//    @Override
//    public void update(Library library) {
//        System.out.println("Customer " + Name + " received a library update.");
//    }


//    @Override
//    public void update() {
//
//    }
}
