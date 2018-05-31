package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Naslov;
import praktikum.Entities.Objekt;
import praktikum.Entities.Tip_Objekta;

import javax.persistence.Column;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ObjektDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NaslovDao NaslovDao;

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

    public List<Objekt> getObjektByID(Integer fk_id_tip_objekta) {
        if (fk_id_tip_objekta==null){
            return getAllObjekti();
        }

        String sql = "SELECT naziv FROM objekt WHERE fk_id_tip_objekta = ?";
        List<Objekt> ret = new ArrayList<Objekt>();
        List<Map<String,Object>> rows  = jdbcTemplate.queryForList(sql,
                new Object[] { fk_id_tip_objekta });
        for (Map row : rows) {
            String naziv = (String) row.get("Naziv");

            ret.add(new Objekt(naziv));
        }
        return ret;
    }


    public int addObjekt(String naziv,String naslov, String tip_objekta ) {
        //DODAJ NASLOV
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
    public Objekt getObjektByNaziv(String naziv){
        Objekt objekt = null;
        if(naziv == null){
            return null;
        } else {
            String sql = "SELECT * FROM objekt WHERE naziv = ?";
            List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql,  new Object[] {naziv});
            for (Map row : rows){
                String naz = (String) row.get("naziv");
                int id = (int) row.get("id_objekt");
                objekt= new Objekt(id,naz);
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