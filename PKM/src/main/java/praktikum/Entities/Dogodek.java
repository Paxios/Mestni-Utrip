package praktikum.Entities;


public class Dogodek {
    private int id_dogodek;
    private String naziv;
    private double vstopnina;
    private int kapaciteta;
    private String datumZacetka;
    private String datumKonca;
    private String opis;
    private int lajk;
    private Objekt objekt;

    public Dogodek(String naziv, double vstopnina, int kapaciteta, String opis, String datumZacetka, String datumKonca){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
    }

    public Dogodek(String naziv, double vstopnina, String datumZacetka, String datumKonca, String imeObjekta){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
        objekt = new Objekt(imeObjekta);
    }
    public Dogodek(int id_dogodek, String naziv, double vstopnina, String datumZacetka, String datumKonca, String imeObjekta, int lajk){
        this.id_dogodek=id_dogodek;
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
        objekt = new Objekt(imeObjekta);
        this.lajk= lajk;
    }
    public Dogodek(int id_dogodek, String naziv, double vstopnina, String datumZacetka, String datumKonca, String imeObjekta){
        this.id_dogodek=id_dogodek;
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
        objekt = new Objekt(imeObjekta);
    }

    public Dogodek(String naziv, double vstopnina, int kapaciteta, String opis, String datumZacetka, String datumKonca, String imeObjekta){
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
        objekt = new Objekt(imeObjekta);
    }

    public Dogodek(int id_dogodek, String naziv, double vstopnina, int kapaciteta, String opis, String datumZacetka, String datumKonca, String imeObjekta, int lajk){
        this.id_dogodek=id_dogodek;
        this.naziv = naziv;
        this.vstopnina = vstopnina;
        this.kapaciteta = kapaciteta;
        this.opis = opis;
        this.datumZacetka=datumZacetka;
        this.datumKonca =datumKonca;
        objekt = new Objekt(imeObjekta);
        this.lajk = lajk;
    }

    public Dogodek(int id_dogodek, String naziv, double vstopnina, int kapaciteta, String opis, String datumZacetka, String datumKonca, String imeObjekta){
        this.id_dogodek=id_dogodek;
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

    public String getDatumZacetka(){ return datumZacetka; }

    public void setDatumZacetka(){this.datumZacetka=datumZacetka;}

    public String getDatumKonca(){return datumKonca;}

    public void setDatumKonca(){this.datumKonca=datumKonca; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Objekt getObjekt() {
        return objekt;
    }

    public void setObjekt(Objekt objekt) {
        this.objekt = objekt;
    }

    public String getImeObjekta() {
        return objekt.getNaziv();
    }

    public void setImeObjekta(String imeObjekta) {
        objekt.setNaziv(imeObjekta);
    }

    public int getId_dogodek() { return id_dogodek; }

    public void setId_dogodek(int id_dogodek) { this.id_dogodek = id_dogodek; }

    public int getLajk() {
        return lajk;
    }

    public void setLajk(int lajk) {
        this.lajk = lajk;
    }
}