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

    public int addObjekt(String naziv){

        String sql ="INSERT into Objekt(naziv) values(naziv)";

        return jdbcTemplate.update(sql, new Object[]{naziv});
    }
}
