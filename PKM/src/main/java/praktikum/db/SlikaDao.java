package praktikum.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import praktikum.Entities.Slika;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Component
public class SlikaDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(MultipartFile f,int fk_id_dogodek){
        try {
            LobHandler lobhandler = new DefaultLobHandler();
            final File blobIn = convert(f);
            final InputStream blobIs = new FileInputStream(blobIn);
            jdbcTemplate.execute(
                    "INSERT INTO slika (datoteka, fk_id_dogodek) VALUES (?,?)",
                    new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
                        protected void setValues(PreparedStatement ps, LobCreator lobCreator)
                                throws SQLException {
                            //ps.setLong(1, 1L);
                            lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int) blobIn.length());
                            ps.setString(2, ""+fk_id_dogodek);
                        }
                    }
            );
            blobIs.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public File convert(MultipartFile file)
    {
        try {
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        }
        catch(IOException e){
            System.out.println(e);
        }
        return null;
    }

    public List<Slika> getSlikaByFK(int id) {
        String sql = "SELECT * FROM slika WHERE fk_id_dogodek = " + id +" GROUP BY fk_id_dogodek;";
        List<Slika> ret = new ArrayList<Slika>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            byte[] blob = (byte[]) row.get("datoteka");
            String retrieveBlobAsString = Base64.getEncoder().encodeToString(blob);
            int fk_id_dogodek=(int)row.get("fk_id_dogodek");

            ret.add(new Slika(retrieveBlobAsString));
        }
        return ret;
    }

    public List<Slika> vrniSlikoDogodka() {
        String sql = "SELECT fk_id_dogodek, datoteka from slika where fk_id_dogodek in (select id_dogodek from dogodek) group by fk_id_dogodek;";
        List<Slika> ret = new ArrayList<Slika>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            byte[] blob = (byte[]) row.get("datoteka");
            String retrieveBlobAsString = Base64.getEncoder().encodeToString(blob);
            int fk_id_dogodek=(int)row.get("fk_id_dogodek");

            ret.add(new Slika(retrieveBlobAsString, fk_id_dogodek));
        }
        return ret;
    }
}