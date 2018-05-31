package praktikum.Entities;

public class Tip_Objekta {
    private int id;
    private String naziv;

    public Tip_Objekta(){

    }
    public Tip_Objekta(int id, String naziv){
    id=this.id;
    naziv=this.naziv;
    }
    public Tip_Objekta(String naziv){
    naziv=this.naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
