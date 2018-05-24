package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Dogodek;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DogodekDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dogodek> getAllDogodki(){
        String sql = "SELECT * FROM Dogodek";
        List<Dogodek> ret = new ArrayList<Dogodek>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            String naziv = (String)row.get("naziv");
            double vstopnina = (double)row.get("vstopnina");
            int kapaciteta = (int)row.get("kapaciteta");
            String opis = (String)row.get("opis");

            ret.add(new Dogodek(naziv, vstopnina, kapaciteta, opis));
        }
        return ret;
    }

    public int addDogodek(String naziv, double vstopnina, int kapaciteta, String opis){

        String sql = "INSERT INTO Dogodek(naziv,vstopnina,kapaciteta,opis) VALUES (?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[]{naziv,vstopnina,kapaciteta,opis});
    }


}
