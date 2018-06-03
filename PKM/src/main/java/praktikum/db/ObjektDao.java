package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Objekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ObjektDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NaslovDao NaslovDao;

    public Objekt getObjektByFK(int id) {
        String sql = "SELECT * FROM Objekt WHERE Fk_id_tip_objekta = id";
        Objekt o = (Objekt) jdbcTemplate.queryForList(sql, id);
        new BeanPropertyRowMapper(Objekt.class);
        return o;
    }

    public List<Objekt> getAllObjekti(){
        String sql = "SELECT * FROM Objekt";
        List<Objekt> ret = new ArrayList<Objekt>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            String naziv = (String) row.get("naziv");
            int idTipObjekta = (int)row.get("fk_id_tip_objekta");
            ret.add(new Objekt(naziv));
        }
        return ret;
    }

    public int addObjekt(String naziv,String naslov, String tip_objekta ) {
        int fk_tip_objekta=0;
        String sqlTip_Objekta = "select * from tip_objekta where naziv = ?";
        List<Map<String,Object>> rows  = jdbcTemplate.queryForList(sqlTip_Objekta,
                new Object[] { tip_objekta});
        for(Map row: rows){
            fk_tip_objekta = (int) row.get("id_tip_objekta");
        }

        NaslovDao.addNaslov(naslov);
        int fk_id_naslov=NaslovDao.getId_NaslovByNaslov(naslov);                                                                                         //TO JE TREBA POPRAVIT


        String sql = "INSERT into objekt (naziv,fk_id_naslov,fk_id_tip_objekta) values(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{naziv,fk_id_naslov,fk_tip_objekta});

    }
    public Objekt getObjektByNaziv(String nazi){
        Objekt objekt = null;
        if(nazi == null){
            return null;
        } else {
            String sql = "SELECT * FROM objekt WHERE naziv = ?";
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,  new Object[] {nazi});
            for (Map row : rows){
                String naziv = (String) row.get("naziv");
                int id = (int) row.get("id_objekt");
                objekt= new Objekt(id,naziv);
            }
            return objekt;
        }
    }

    public Objekt getObjektById(int id) {

        String sql = "SELECT * FROM Objekt WHERE idObjekt = id";
        Objekt o = (Objekt) jdbcTemplate.queryForList(sql, id);
        new BeanPropertyRowMapper(Objekt.class);
        return o;
    }
}