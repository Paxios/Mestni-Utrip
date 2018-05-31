package praktikum.Entities;

public class Naslov {
    private int id_naslov;
    private double z_sirina; //nullable
    private double z_dolzina; //nullable
    private String opis;

    public Naslov(){

    }
    public Naslov(int id_naslov, double z_sirina, double z_dolzina, String opis){
    id_naslov = this.id_naslov;
    z_sirina= this.z_sirina;
    z_dolzina= this.z_dolzina;
    opis= this.opis;
    }
    public Naslov(double z_sirina, double z_dolzina){
        z_dolzina=this.z_dolzina;
        z_sirina=this.z_sirina;
    }
    public Naslov(String opis){
    opis=this.opis;
    }

    public int getId_naslov() {
        return id_naslov;
    }

    public void setId_naslov(int id_naslov) {
        this.id_naslov = id_naslov;
    }

    public double getZ_sirina() {
        return z_sirina;
    }

    public void setZ_sirina(double z_sirina) {
        this.z_sirina = z_sirina;
    }

    public double getZ_dolzina() {
        return z_dolzina;
    }

    public void setZ_dolzina(double z_dolzina) {
        this.z_dolzina = z_dolzina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Naslov(int id_naslov){
        id_naslov=this.id_naslov;

    }
}
