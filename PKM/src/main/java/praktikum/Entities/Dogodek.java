package praktikum.Entities;

public class Dogodek {
    private String naziv;
    private double vstopnina;
    private int kapaciteta;
    private String opis;
    private Objekt objekt;

    public Dogodek(String naziv, double vstopnina, int kapaciteta, String opis){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
    }

    public Dogodek(String naziv, double vstopnina, int kapaciteta, String opis, String imeObjekta){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        objekt = new Objekt(imeObjekta);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getVstopnina() {
        return vstopnina;
    }

    public void setVstopnina(double vstopnina) {
        this.vstopnina = vstopnina;
    }

    public int getKapaciteta(){return kapaciteta;}

    public void setKapaciteta(){this.kapaciteta=kapaciteta; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}