package Domain;

public class PC {
    public PC(int idPC, String name) {
        this.idPC = idPC;
        Name = name;
    }

    public int idPC;
    public String Name;


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
