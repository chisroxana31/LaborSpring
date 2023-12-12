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
@Table(name = "PC")
/*Aici trebuie modificat in functie de numele tabelului din baza de date*/
public class PC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPC;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "idRoom")
    private PCRooms pcRoom;

    // Rest of the code remains unchanged...

    public PCRooms getPCRoom() {
        return pcRoom;
    }

    public void setPCRoom(PCRooms pcRoom) {
        this.pcRoom = pcRoom;
    }

    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
