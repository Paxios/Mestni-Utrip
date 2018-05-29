package praktikum.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "uporabnik")
public class Uporabnik {
    private Long id;
    private String uporabniskoIme;
    private String geslo;
    private String ponoviGeslo;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUporabniskoIme() {
        return uporabniskoIme;
    }

    public void setUporabniskoIme(String uporabniskoIme) {
        this.uporabniskoIme = uporabniskoIme;
    }


    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    @Transient
    public String getPonoviGeslo() {
        return ponoviGeslo;
    }

    public void setPonoviGeslo(String ponoviGeslo) {
        this.ponoviGeslo = ponoviGeslo;
    }


    @ManyToMany
    @JoinTable(name = "uporabnik_role", joinColumns = @JoinColumn(name = "uporabnik_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
