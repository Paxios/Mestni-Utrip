package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Objekt;
import praktikum.Entities.Oseba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OsebaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ObjektDao objektDao;

    public List<Oseba> getAllOsebe(){
        String sql = "SELECT * FROM Uporabnik";
        List<Oseba> ret = new ArrayList<Oseba>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            String lastnik = (String)row.get("lastnik");
            String mail = (String)row.get("mail");
            String uporabniskoIme = (String)row.get("uporabnisko_ime");
            String geslo = (String)row.get("geslo");
            int idObjekt = (int)row.get("fk_id_objekt");
            Objekt objekt = objektDao.getObjektById(idObjekt);

            ret.add(new Oseba(lastnik,mail,uporabniskoIme,geslo,objekt.getNaziv()));
        }
        return ret;
    }

    public Oseba getOsebaByUsername(String uporabniskoIme) {
        if(uporabniskoIme == null){
            return null;
        } else {
            String sql = "SELECT * FROM Uporabnik WHERE uporabnisko_ime = uporabniskoIme";
            Oseba o = (Oseba) jdbcTemplate.queryForList(sql, new Object[]{uporabniskoIme},
                    new BeanPropertyRowMapper(Oseba.class));
            return o;
        }
    }


    public int addOseba(String uporabniskoIme, String geslo, String lastnik, String mail, int idObjekt){
        String sql = "INSERT into Uporabnik (lastnik,mail,uporabnisko_ime, geslo, fk_id_objekt) values (?,?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[]{uporabniskoIme, geslo, lastnik, mail, idObjekt});
    }
}
