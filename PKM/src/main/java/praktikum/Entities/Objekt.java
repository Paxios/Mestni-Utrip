package praktikum.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import praktikum.db.ObjektDao;

public class Objekt {
    private int id;
    private String naziv;
    private int idTipObjekta;
    @Autowired
    ObjektDao ObjektDao;

    public Objekt(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }
    public Objekt (String naziv, int idTipObjekta){
        this.naziv =naziv;
        this.idTipObjekta =idTipObjekta;
    }

    public Objekt(String naziv) {

        this.naziv = naziv;
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