package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import praktikum.Entities.Oseba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OsebaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Oseba> getAllOsebe(){
        String sql = "SELECT * FROM Uporabnik";
        List<Oseba> ret = new ArrayList<Oseba>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row: rows){
            Integer id = (Integer)row.get("id");
            String ime = (String)row.get("ime");
            String priimek = (String)row.get("priimek");
            String mail = (String)row.get("mail");
            String uporabniskoIme = (String)row.get("uporabnisko_ime");
            String geslo = (String)row.get("geslo");

            ret.add(new Oseba(ime,priimek,mail,uporabniskoIme,geslo));
        }
        return ret;
    }

    public Oseba getOsebaByUsername(String uporabniskoIme) {
        if(uporabniskoIme == null){
            return null;
        }
        String sql = "SELECT * FROM Uporabnik WHERE uporabnisko_ime = uporabniskoIme";
        Oseba o = (Oseba) jdbcTemplate.queryForList(sql, new Object[]{uporabniskoIme},
                new BeanPropertyRowMapper(Oseba.class));
        return o;
    }


    public int addOseba(String ime, String priimek, String mail, String uporabniskoIme, String geslo){

        String sql = "INSERT into Uporabnik (ime, priimek, mail,uporabnisko_ime, geslo) values (ime,priimek,mail,uporabniskoIme,geslo)";

        return jdbcTemplate.update(sql, new Object[]{ime, priimek, mail, uporabniskoIme, geslo});
    }
}
