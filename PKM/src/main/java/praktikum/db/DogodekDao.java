package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Dogodek;
import praktikum.Entities.Objekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DogodekDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired ObjektDao objektDao;

    public List<Dogodek> getAllDogodki(){
        String sql = "SELECT * FROM Dogodek";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            String naziv = (String)row.get("naziv");
            double vstopnina = (double)row.get("vstopnina");
            int kapaciteta = (int)row.get("kapaciteta");
            String opis = (String)row.get("opis");
//            int idObjekt = (int)row.get("fk_id_objekt");
//            Objekt o = objektDao.getObjektById(idObjekt);

            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis/*o.getNaziv()*/));
        }
        return ret;
    }

    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis){

        String sql = "INSERT INTO Dogodek(naziv,vstopnina,kapaciteta,opis) VALUES (?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[]{naziv,vstopnina,kapaciteta,opis});
    }

    public List<Dogodek> getDogodekByID(int fk_id_tip_objekta) {

        String sql = "SELECT dogodek.Naziv, dogodek.Vstopnina, dogodek.Kapaciteta, dogodek.Opis FROM dogodek, objekt, tip_objekta WHERE dogodek.Fk_id_objekt = objekt.Id_objekt AND objekt.Fk_id_tip_objekta = tip_objekta.Id_tip_objekta AND Tip_objekta.Id_tip_objekta = ?";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
                new Object[]{fk_id_tip_objekta});
        for (Map row : rows) {
            String naziv = (String) row.get("naziv");
            double vstopnina = (double) row.get("vstopnina");
            int kapaciteta = (int) row.get("kapaciteta");
            String opis = (String) row.get("opis");
//            int idObjekt;
//            if ((Integer)row.get("fk_id_objekt") == null) {
//                idObjekt = -1;
//            }else{
//                idObjekt = (int) row.get("fk_id_objekt");
//            }
//            Objekt o = objektDao.getObjektById(idObjekt);

            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis /*o.getNaziv()*/));
        }
        return ret;
    }
}