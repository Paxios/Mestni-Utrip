package praktikum.Entities;

public class Slika {
    private int id_slika;
    private byte[] datoteka;
    private int fk_id_dogodek;

    public Slika (int id_slika, byte[] datoteka, int fk_id_dogodek){
        this.id_slika=id_slika;
        this.datoteka=datoteka;
        this.fk_id_dogodek=fk_id_dogodek;
    }

    public int getId_slika() {
        return id_slika;
    }

    public void setId_slika(int id_slika) {
        this.id_slika = id_slika;
    }

    public byte[] getDatoteka() {
        return datoteka;
    }

    public void setDatoteka(byte[] datoteka) {
        this.datoteka = datoteka;
    }

    public int getFk_id_dogodek() {
        return fk_id_dogodek;
    }

    public void setFk_id_dogodek(int fk_id_dogodek) {
        this.fk_id_dogodek = fk_id_dogodek;
    }
}
