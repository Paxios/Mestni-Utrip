package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Tip_ObjektaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllTipObjekti(){
        String sql="select * from tip_objekta";
        List<String> tipiObjektov = new ArrayList<String>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows) {
            String naziv = (String) row.get("naziv");
            tipiObjektov.add(naziv);
        }
        return tipiObjektov;
    }
}
