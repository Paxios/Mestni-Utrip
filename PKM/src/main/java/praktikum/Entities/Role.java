package praktikum.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Role {
    private Long id;
    private String ime;
    private Set<Uporabnik> uporabniki;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<Uporabnik> getUporabniki() {
        return uporabniki;
    }

    public void setUporabniki(Set<Uporabnik> uporabniki) {
        this.uporabniki = uporabniki;
    }
}
