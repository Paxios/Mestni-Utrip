package praktikum.Entities;

public class Oseba {
    private int id;

    private String ime;
    private String priimek;
    private String mail;
    private String uporabniskoIme;
    private String geslo;


    public Oseba(String ime, String priimek, String mail, String uporabniskoIme, String geslo){
        this.ime = ime;
        this.priimek = priimek;
        this.mail = mail;
        this.uporabniskoIme = (ime.toLowerCase() + priimek.toLowerCase() + "Mstni");
        this.geslo = geslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getUporabniskoIme() {
        return uporabniskoIme;
    }

    public void setUporabniskoIme(String uporabniskoIme) {
        this.uporabniskoIme = uporabniskoIme;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }
}
