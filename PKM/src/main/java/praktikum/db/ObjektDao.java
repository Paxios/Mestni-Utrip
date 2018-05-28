package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Objekt;

import javax.persistence.Column;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ObjektDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Objekt> getAllObjekti(){
        String sql = "SELECT * FROM Objekt";
        List<Objekt> ret = new ArrayList<Objekt>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            String naziv = (String) row.get("naziv");
            ret.add(new Objekt(naziv));
        }

        return ret;
    }

    public int addObjekt(String naziv) {
        String sql = "INSERT into objekt (naziv) values(?)";
                                                                                    //NE DELA iz neznanega razloga
        return jdbcTemplate.update(sql, new Object[]{naziv});
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
