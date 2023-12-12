package Domain;

import Domain.Library;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PCRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoom;

    private String Name;

    @OneToOne
    @JoinColumn(name = "idLibrary")
    private Library library;

    @OneToMany(mappedBy = "pcRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PC> pcs = new ArrayList<>();




    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<PC> getPCs() {
        return pcs;
    }

    public void setPCs(List<PC> pcs) {
        this.pcs = pcs;
        for (PC pc : pcs) {
            pc.setPCRoom(this);
        }
    }

    public void addPC(PC pc) {
        pcs.add(pc);
        pc.setPCRoom(this);
    }


    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
