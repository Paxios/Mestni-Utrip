package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import praktikum.Entities.Dogodek;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class DogodekDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ObjektDao objektDao;
    @Autowired
    NaslovDao NaslovDao;
    @Autowired
    Tip_ObjektaDao tip_objektaDao;
    @Autowired
    SlikaDao slikaDao;
    @Autowired
    DogodekDao dogodekDao;

//    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
//    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
//    private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");
//
//    public static String toSlug(String input) {
//        String nowhitespace = WHITESPACE.matcher("text").replaceAll("-");
//        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
//        String slug = NONLATIN.matcher(normalized).replaceAll("");
//        slug = EDGESDHASHES.matcher(slug).replaceAll("");
//        return slug.toLowerCase(Locale.ENGLISH);
//    }

    public List<Dogodek> getAllDogodki(){
        String sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt;";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            int id_dogodek = (int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double)row.get("vstopnina");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            String zacetekk = DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc = DATE_FORMAT.format(konec);
            LocalDateTime datumZacetka = zacetek.toLocalDateTime();
            LocalDateTime datumKonca = konec.toLocalDateTime();
            String predogled = slikaDao.getIDSlike(id_dogodek);

            ret.add(new Dogodek(id_dogodek, naziv_dogodka, predogled, vstopnina, zacetekk, konecc, naziv_objekta));

        }
        return ret;
    }

    public List<Dogodek> getAllDogodkiOrdered(String preveri){
        String sql;
        if (preveri != null && preveri.endsWith ("Po datumu")){
            sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt ORDER BY dogodek.datum_zacetka;";

        } else {
            sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt ORDER BY objekt.naziv;";

        }
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            int id_dogodek = (int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double)row.get("vstopnina");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            String zacetekk = DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc = DATE_FORMAT.format(konec);
            LocalDateTime datumZacetka = zacetek.toLocalDateTime();
            LocalDateTime datumKonca = konec.toLocalDateTime();
            String predogled = slikaDao.getIDSlike(id_dogodek);

            ret.add(new Dogodek(id_dogodek, naziv_dogodka, predogled, vstopnina, zacetekk, konecc, naziv_objekta));
        }
        return ret;
    }

//    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis) {
//
//        String sql = "INSERT INTO Dogodek(naziv,vstopnina,kapaciteta,opis) VALUES (?,?,?,?)";
//
//        return jdbcTemplate.update(sql, new Object[]{naziv, vstopnina, kapaciteta, opis});
//    }


    public List<Dogodek> getDogodekByFK(int fk) {
        String sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt WHERE objekt.Fk_id_tip_objekta=?;";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{fk});
        for (Map row : rows) {
            int id_dogodek = (int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double) row.get("vstopnina");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            String zacetekk = DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc = DATE_FORMAT.format(konec);
            String predogled = slikaDao.getIDSlike(id_dogodek);

            ret.add(new Dogodek(id_dogodek, naziv_dogodka, predogled, vstopnina, zacetekk, konecc, naziv_objekta));
        }
        return ret;
    }

    public List<Dogodek> getDogodekByFKOrdered(int fk, String preveri) {
        String sql;
        if (preveri != null && preveri.endsWith ("Po datumu")){
            sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt WHERE objekt.Fk_id_tip_objekta=? ORDER BY dogodek.datum_zacetka;";

        } else {
            sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt WHERE objekt.Fk_id_tip_objekta=? ORDER BY objekt.naziv;";

        }
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{fk});
        for (Map row : rows) {
            int id_dogodek = (int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double) row.get("vstopnina");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            String zacetekk = DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc = DATE_FORMAT.format(konec);
            String predogled = slikaDao.getIDSlike(id_dogodek);

            ret.add(new Dogodek(id_dogodek, naziv_dogodka, predogled, vstopnina, zacetekk, konecc, naziv_objekta));
        }
        return ret;
    }

    public List<Dogodek> getDogodekByID(int id) {
        String sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina, kapaciteta, opis,lajk FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt WHERE dogodek.id_dogodek=?;";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{id});
        for (Map row : rows) {
            int id_dogodek =(int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double) row.get("vstopnina");
            int kapaciteta = (int) row.get("kapaciteta");
            String opis = (String) row.get("opis");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String zacetekk= DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc= DATE_FORMAT.format(konec);
            int lajk = (int) row.get("Lajk");
            String predogled = slikaDao.getIDSlike(id_dogodek);
            ret.add(new Dogodek(id_dogodek, naziv_dogodka, vstopnina, kapaciteta, opis, zacetekk, konecc, naziv_objekta,lajk));
        }
        return ret;
    }


    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis, LocalDate datum_zac, LocalTime ura_zac, LocalDate datum_konc, LocalTime ura_konc, String tip_objetka, String objekt) {
        int fk_id_objekt = 0;
        int fk_id_tip_dogodka = 0;
        int fk_id_username = 0;
        int lajk = 0;
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        String sql_Uporabnik = "select * from uporabnik where uporabnisko_ime= ?";
        List<Map<String, Object>> abc = jdbcTemplate.queryForList(sql_Uporabnik,
                new Object[]{username});
        for (Map vrstice : abc) {
            fk_id_username = (int) vrstice.get("id_uporabnik");

        }

        String sqlTip_Objekta = "select * from tip_dogodka where naziv = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlTip_Objekta,
                new Object[]{tip_objetka});
        for (Map row : rows) {
            fk_id_tip_dogodka = (int) row.get("id_tip_dogodka");
        }
        fk_id_objekt = objektDao.getObjektByNaziv(objekt).getId();
        String zacetek = datum_zac + " " + ura_zac + ":00";
        zacetek.replace('/', '-');
        String konec = datum_konc + " " + ura_konc + ":00";
        konec.replace('/', '-');

        String sql = "insert into dogodek values (NULL, ?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{naziv, vstopnina, kapaciteta, opis, zacetek, konec,lajk, fk_id_objekt, fk_id_tip_dogodka, fk_id_username});
    }



    public Integer getIdDogodka(String nazi){
        int id_dogodek= 0;
        if(nazi == null){
            return null;
        } else {
            String sql = "SELECT id_dogodek, naziv FROM dogodek WHERE naziv = ?";
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,  new Object[] {nazi});
            for (Map row : rows){
                String naziv = (String) row.get("naziv");
                id_dogodek = (int) row.get("id_dogodek");
            }
            return id_dogodek;
        }
    }

    public List<Dogodek> getDogodkiByLoginedUser(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        String sql="select dogodek.naziv as naziv_dogodka, objekt.naziv as naziv_objekta, id_dogodek,vstopnina,datum_zacetka,datum_konca from dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt where fk_id_uporabnik= (select id_uporabnik from uporabnik where Uporabnisko_ime = ?)";

        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,username);
        for(Map row: rows){
            int id_dogodek = (int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double)row.get("vstopnina");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            String zacetekk = DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc = DATE_FORMAT.format(konec);
            String predogled = slikaDao.getIDSlike(id_dogodek);

            ret.add(new Dogodek(id_dogodek, naziv_dogodka, predogled, vstopnina, zacetekk, konecc, naziv_objekta));
        }
        return ret;
    }


    public int updateDogodek (String novNaziv,String naziv, double vstopnina, int kapaciteta, String opis, LocalDate datum_zac, LocalTime ura_zac, LocalDate datum_konc, LocalTime ura_konc, String tip_objetka, String objekt){
        int fk_id_objekt;
        int fk_id_tip_dogodka = 0;
        int fk_id_username = 0;
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        String sql_Uporabnik = "select * from uporabnik where uporabnisko_ime= ?";
        List<Map<String, Object>> abc = jdbcTemplate.queryForList(sql_Uporabnik,
                new Object[]{username});
        for (Map vrstice : abc) {
            fk_id_username = (int) vrstice.get("id_uporabnik");
        }

        String sqlTip_Objekta = "select * from tip_dogodka where naziv = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlTip_Objekta,
                new Object[]{tip_objetka});
        for (Map row : rows) {
            fk_id_tip_dogodka = (int) row.get("id_tip_dogodka");
        }
        String zacetek = datum_zac + " " + ura_zac + ":00";
        zacetek.replace('/', '-');
        String konec = datum_konc + " " + ura_konc + ":00";
        konec.replace('/', '-');
        String sqlUpdate = "update dogodek set naziv=?, vstopnina=?, kapaciteta=?,opis=?,datum_zacetka=?,datum_konca=?,fk_id_tip_dogodka=?,fk_id_uporabnik=?" +
                " where naziv=?";
        return jdbcTemplate.update(sqlUpdate, new Object[]{novNaziv,vstopnina, kapaciteta, opis, zacetek, konec, fk_id_tip_dogodka, fk_id_username, naziv});
    }

    public String get_dogodek_by_naziv (int id){
        String opis = new String();
        String sql = "SELECT opis FROM naslov WHERE id_naslov = (SELECT fk_id_naslov FROM objekt WHERE id_objekt = (SELECT fk_id_objekt From Dogodek Where id_dogodek = ?));";

        List<Map<String, Object>> abc = jdbcTemplate.queryForList(sql,
                new Object[]{id});
        for (Map vrstice : abc) {
            opis = (String) vrstice.get("opis");
        }


        return opis;
    }

    public double get_lat (int id){
        double lat= 0;
        String sql = " SELECT Z_sirina FROM naslov WHERE id_naslov = (SELECT fk_id_naslov FROM objekt WHERE id_objekt = (SELECT fk_id_objekt From Dogodek Where id_dogodek = ?));";

        List<Map<String, Object>> abc = jdbcTemplate.queryForList(sql,
                new Object[]{id});
        for (Map vrstice : abc) {
            lat = (double) vrstice.get("Z_sirina");
        }
        return lat;

    }
    public double get_lng (int id){
        double lng= 0;
        String sql = "SELECT Z_dolzina FROM naslov WHERE id_naslov = (SELECT fk_id_naslov FROM objekt WHERE id_objekt = (SELECT fk_id_objekt From Dogodek Where id_dogodek = ?));";

        List<Map<String, Object>> abc = jdbcTemplate.queryForList(sql,
                new Object[]{id});
        for (Map vrstice : abc) {
            lng = (double) vrstice.get("Z_dolzina");
        }
        return lng;

    }

    public int updateLajk(String objekt){
        List<Dogodek> lajk = dogodekDao.getDogodekByNaziv(objekt);
        System.out.println(lajk.get(0));
        int stLajkov = lajk.get(0).getLajk()+1;

        String sqlUpdate = "update dogodek set Lajk=? where naziv = ?";
        return jdbcTemplate.update(sqlUpdate, new Object[]{stLajkov, objekt});
    }

    public List<Dogodek> getDogodekByNaziv(String naziv) {
        String sql = "SELECT dogodek.id_dogodek, dogodek.Naziv AS naziv_dogodka, objekt.naziv AS naziv_objekta, datum_zacetka, datum_konca, vstopnina, kapaciteta, opis,lajk FROM dogodek LEFT JOIN objekt ON objekt.Id_objekt = dogodek.Fk_id_objekt WHERE dogodek.naziv=?;";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{naziv});
        for (Map row : rows) {
            int id_dogodek =(int) row.get("id_dogodek");
            String naziv_dogodka = (String) row.get("naziv_dogodka");
            String naziv_objekta = (String) row.get("naziv_objekta");
            double vstopnina = (double) row.get("vstopnina");
            int kapaciteta = (int) row.get("kapaciteta");
            String opis = (String) row.get("opis");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String zacetekk= DATE_FORMAT.format(zacetek);
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            String konecc= DATE_FORMAT.format(konec);
            int lajk = (int) row.get("Lajk");
            ret.add(new Dogodek(id_dogodek, naziv_dogodka, vstopnina, kapaciteta, opis, zacetekk, konecc, naziv_objekta,lajk));
        }
        return ret;
    }
}