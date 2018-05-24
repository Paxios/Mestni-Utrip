package praktikum.Entities;

public class Oseba {

    private String lastnik;
    private String mail;
    private String uporabniskoIme;
    private String geslo;
    private Objekt objekt;


    public Oseba(String lastnik, String mail, String uporabniskoIme, String geslo, String imeObjekta){
        this.lastnik = lastnik;
        this.mail = mail;
        this.uporabniskoIme = (imeObjekta.toLowerCase() + "Mstni");
        this.geslo = geslo;
        objekt = new Objekt(imeObjekta);
    }

    public String getLastnik() { return lastnik; }

    public void setLastnik(String lastnik) { this.lastnik = lastnik; }

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
