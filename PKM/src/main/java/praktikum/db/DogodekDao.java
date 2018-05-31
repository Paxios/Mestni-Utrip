package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Dogodek;
import praktikum.Entities.Objekt;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import praktikum.Entities.Dogodek;

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

    public List<Dogodek> getAllDogodki() {
        String sql = "SELECT*FROM Dogodek";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            String naziv = (String) row.get("naziv");
            double vstopnina = (double) row.get("vstopnina");
            int kapaciteta = (int) row.get("kapaciteta");
            String opis = (String) row.get("opis");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            Timestamp konec = (Timestamp) row.get("datum_Konca");
            LocalDateTime datumZacetka = zacetek.toLocalDateTime();
            LocalDateTime datumKonca = konec.toLocalDateTime();
//            int id = (int)row.get("fk_id_objekt");
//            Objekt o = objektDao.getObjektById(id);
//            String nazivObjekta = o.getNaziv();

            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis, datumZacetka, datumKonca));
        }
        return ret;
    }

    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis) {

        String sql = "INSERT INTO Dogodek(naziv,vstopnina,kapaciteta,opis) VALUES (?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[]{naziv, vstopnina, kapaciteta, opis});
    }

    //    public List<Dogodek> getDogodekByID(int fk_id_tip_objekta) {
//
//        String sql = "SELECT * FROM dogodek, objekt, tip_objekta WHERE dogodek.Fk_id_objekt =objekt.Id_objekt AND objekt.Fk_id_tip_objekta = ?;";
//        List<Dogodek> ret = new ArrayList<Dogodek>();
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
//                new Object[]{fk_id_tip_objekta});
//        for (Map row : rows) {
//            String naziv = (String) row.get("naziv");
//            double vstopnina = (double) row.get("vstopnina");
//            int kapaciteta = (int) row.get("kapaciteta");
//            String opis = (String) row.get("opis");
//            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
//            Timestamp konec =(Timestamp)row.get("datum_Konca");
//            LocalDateTime datumZacetka = zacetek.toLocalDateTime();
//            LocalDateTime datumKonca = konec.toLocalDateTime();
//            //int idObjekt = (int)row.get("Fk_id_objekt");
////            Objekt o = objektDao.getObjektByFK(fk_id_tip_objekta);
////            String imeObjekta = o.getNaziv();
//
//            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis, datumZacetka,datumKonca /*imeObjekta*/));
//        }
//        return ret;
//    }

    public List<Dogodek> getDogodekByID(int fk) {

        String sql = "SELECT * FROM dogodek, objekt WHERE dogodek.Fk_id_objekt = objekt.Id_objekt AND objekt.Fk_id_tip_objekta = ?";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{fk});
        for (Map row : rows) {
            String naziv = (String) row.get("naziv");
            double vstopnina = (double) row.get("vstopnina");
            int kapaciteta = (int) row.get("kapaciteta");
            String opis = (String) row.get("opis");
            Timestamp zacetek = (Timestamp) row.get("datum_Zacetka");
            Timestamp konec =(Timestamp)row.get("datum_Konca");
            LocalDateTime datumZacetka = zacetek.toLocalDateTime();
            LocalDateTime datumKonca = konec.toLocalDateTime();
//            Objekt o = objektDao.getObjektByFK(fk);
//            String nazivObjekta = o.getNaziv();
            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis, datumZacetka, datumKonca));
        }
        return ret;
    }




    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis, LocalDate datum_zac, LocalTime ura_zac, LocalDate datum_konc, LocalTime ura_konc, String tip_objetka, String objekt) {
        int fk_id_objekt = 0;
        int fk_id_tip_dogodka = 0;
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
        String sql = "insert into dogodek values (NULL, ?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{naziv, vstopnina, kapaciteta, opis, zacetek, konec, fk_id_objekt, fk_id_tip_dogodka});
    }
}