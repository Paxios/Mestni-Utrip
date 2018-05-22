package praktikum.Entities;

public class Objekt {
    private int id;
    private String naziv;


    public Objekt(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

