package praktikum.Entities;

import java.time.LocalDateTime;

public class Dogodek {
    private String naziv;
    private double vstopnina;
    private int kapaciteta;
    private LocalDateTime datumZacetka;
    private LocalDateTime datumKonca;
    private String opis;
    private Objekt objekt;

    public Dogodek(String naziv, double vstopnina, int kapaciteta, String opis, LocalDateTime datumZacetka, LocalDateTime datumKonca){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
    }

    public Dogodek(String naziv, double vstopnina, int kapaciteta,
                   String opis, LocalDateTime datumZacetka, LocalDateTime datumKonca, String imeObjekta){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
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

    public LocalDateTime getDatumZacetka(){ return datumZacetka; }

    public void setDatumZacetka(){this.datumZacetka=datumZacetka;}

    public LocalDateTime getDatumKonca(){return datumKonca;}

    public void setDatumKonca(){this.datumKonca=datumKonca; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}