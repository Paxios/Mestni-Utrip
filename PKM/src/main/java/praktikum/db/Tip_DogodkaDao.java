package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Tip_DogodkaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllTipiDogodka() {
        String sql = "select * from tip_dogodka";
        List<String> tipiDogodkov = new ArrayList<String>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            String naziv = (String) row.get("naziv");
            tipiDogodkov.add(naziv);

        }
        return tipiDogodkov;
    }

    public String getTipDogodkaById(int id){
        String sql = "select naziv from tip_dogodka where id_tip_dogodka=?";
        String nazivDogodka= String.valueOf(jdbcTemplate.queryForList(sql, id));
        nazivDogodka = nazivDogodka.replace("[{naziv=","");
        nazivDogodka = nazivDogodka.replace("}]", "");
        return nazivDogodka;
    }

}
