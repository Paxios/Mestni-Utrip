package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NaslovDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addNaslov(String opis){
        String sql = "insert into naslov (Z_sirina, z_dolzina, opis, fk_id_kraj) values (?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{0,0,opis,1});

    }

    public int getId_NaslovByNaslov(String opis){
        int fk_id_naslov = 0;
        String sqlNaslov = "select id_naslov from naslov where opis = ?";
                List<Map<String,Object>> vrstica = jdbcTemplate.queryForList(sqlNaslov,  new Object[] { opis});
        for(Map row : vrstica){
            fk_id_naslov = (int) row.get("id_naslov");
        }
        return fk_id_naslov;
    }

}


//    String sql = "INSERT into Uporabnik (lastnik,mail,uporabnisko_ime, geslo, fk_id_objekt) values (?,?,?,?,?)";
//
//        return jdbcTemplate.update(sql, new Object[]{uporabniskoIme, geslo, lastnik, mail, idObjekt});