//package praktikum.db;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import praktikum.Entities.Slika;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class SlikaDao {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Slika> getSlikaByFK(int fk) {
//        String sql = "SELECT slika.id_slika, slika.datoteka AS datoteka, slika.fk_id_dogodek FROM slika LEFT JOIN dogodek ON dogodek.id_dogodek = slika.Fk_id_dogodek WHERE slika.Fk_id_tip_dogodka=?;";
//        List<Slika> ret = new ArrayList<Slika>();
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
//                new Object[]{fk});
//        for (Map row : rows) {
//            int id_slika = (int) row.get("id_slika");
//            byte[] datoteka = (byte[]) row.get("datoteka");
//            int fk_id_dogodek = (int) row.get("fk_id_dogodek");
//            ret.add(new Slika(id_slika, datoteka, fk_id_dogodek));
//        }
//        return ret;
//    }
//    public int addSlika(int id_slika, byte[] datoteka, int fk_id_dogodek) {
//        String sql = "insert into slika values (NULL, ?,?,?)";
//        return jdbcTemplate.update(sql, new Object[]{id_slika, datoteka, fk_id_dogodek});
//    }
//}
