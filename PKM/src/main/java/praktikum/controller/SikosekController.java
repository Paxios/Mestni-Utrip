package praktikum.controller;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import praktikum.Entities.Oseba;
import praktikum.Entities.Objekt;
import praktikum.Entities.Dogodek;
import praktikum.db.DogodekDao;
import praktikum.db.OsebaDao;
import praktikum.db.ObjektDao;
import praktikum.db.Tip_ObjektaDao;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class SikosekController {


    @Autowired Tip_ObjektaDao Tip_ObjektaDao;
    @RequestMapping(value = {"/registracija"}, method = RequestMethod.GET)
    public String Prijava(Model model){
        List<String> tip_objekta = Tip_ObjektaDao.getAllTipObjekti();
        model.addAttribute("tip_objekta",tip_objekta);
        return "/registracija";
    }

    @RequestMapping(value = {"/dodajanjeDogodka"}, method = RequestMethod.GET)
    public String Dodaj(){
        return "/dodajanjeDogodka";
    }


    @Autowired OsebaDao OsebaDao;
    @Autowired ObjektDao ObjektDao;
    @RequestMapping(value = {"/registracija"}, method = RequestMethod.POST)
    public String Registracija(Model model,@RequestParam(value="imeP", required = true) String imeP, @RequestParam(value="lastnik", required=true) String lastnik,
                               @RequestParam(value="mail", required = true) String mail, @RequestParam(value="geslo", required=true) String geslo, @RequestParam(value="uporabniskoIme", required=false) String uporabniskoIme,
                               @RequestParam(value="naslov", required = true) String naslov,@RequestParam(value="tip_Podjetja") String tip_objekta) {
        Objekt objekt = new Objekt(imeP);
        ObjektDao.addObjekt(imeP,naslov,tip_objekta);
        Oseba oseba = new Oseba(lastnik,mail, uporabniskoIme, geslo, ObjektDao.getObjektByNaziv(imeP).getNaziv());
        OsebaDao.addOseba(lastnik,mail,oseba.getUporabniskoIme(), geslo, ObjektDao.getObjektByNaziv(imeP).getId());
        return "redirect:/index";

    }

    @RequestMapping(value = {"/prijava"}, method = RequestMethod.POST)
    public String Prijava(Model model, @RequestParam(value="uporabniskoime") String uporabniskoime, @RequestParam(value="geslo") String geslo){

        Oseba o = OsebaDao.getOsebaByUsername(uporabniskoime);

        if(o == null){
            return "redirect:/index";
        }
        else{
            if(geslo == o.getGeslo()){
                return "redirect:/index2";
            }
            else{
                return "redirect:/index";
            }
        }
    }

    @Autowired
    DogodekDao dogodekDao;

    @RequestMapping(value = {"/dodajanjeDogodka"}, method = RequestMethod.POST)
    public String DodajanjeDogodka(Model model, @RequestParam(value="naziv") String naziv, @RequestParam(value="vstopnina") double vstopnina,
                                   @RequestParam(value="kapaciteta") int kapaciteta, @RequestParam(value="tip") String tip, @RequestParam(value="opis") String opis, @RequestParam(value="imeObjekta") String imeObjekta,
                                   @RequestParam(value="datumZacetka") String datumZacetka, @RequestParam(value="uraZacetka") String uraZacetka, @RequestParam(value="datumKonca") String datumKonca,
                                   @RequestParam(value="uraKonca") String uraKonca) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate datumZacetkaa = LocalDate.parse(datumZacetka,formatter);
            LocalDate datumKoncaa = LocalDate.parse(datumKonca,formatter);
            LocalTime uraZac = LocalTime.parse(uraZacetka);
            LocalTime uraKon = LocalTime.parse(uraKonca);
            dogodekDao.addDogodek(naziv, vstopnina, kapaciteta, opis,datumZacetkaa,uraZac,datumKoncaa,uraKon,tip,imeObjekta);
            return "redirect:/index";
        }


    }
