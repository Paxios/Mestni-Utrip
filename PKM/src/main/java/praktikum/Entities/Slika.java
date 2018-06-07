package praktikum.Entities;

public class Slika {
    private int id_slika;
    private String URLSlike;
    private int fk_id_dogodek;

    public Slika (int id_slika, int fk_id_dogodek){
        this.id_slika=id_slika;
        this.fk_id_dogodek=fk_id_dogodek;
    }

    public Slika(String URLSlike){
        this.URLSlike=URLSlike;
    }

    public Slika(String URLSlike, int fk_id_dogodek){
        this.URLSlike=URLSlike;
        this.fk_id_dogodek=fk_id_dogodek;
    }

    public int getId_slika() {
        return id_slika;
    }

    public void setId_slika(int id_slika) {
        this.id_slika = id_slika;
    }

    public String getURLSlike() { return URLSlike; }

    public void setURLSlike(String URLSlike) { this.URLSlike = URLSlike; }

    public int getFk_id_dogodek() {
        return fk_id_dogodek;
    }

    public void setFk_id_dogodek(int fk_id_dogodek) {
        this.fk_id_dogodek = fk_id_dogodek;
    }
}