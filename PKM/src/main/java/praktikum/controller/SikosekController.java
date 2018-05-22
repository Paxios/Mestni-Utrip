package praktikum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import praktikum.Customer;
import praktikum.CustomerRepository;
import praktikum.Entities.Oseba;
import praktikum.db.OsebaDao;
import praktikum.db.ObjektDao;
import java.util.*;

@Controller
public class SikosekController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = {"/registracija"}, method = RequestMethod.GET)
    public String Prijava(){
        return "/registracija";
    }

    @RequestMapping(value = {"/aktualno"}, method = RequestMethod.GET)
    public String aktualno(){
        return"/aktualno";
    }

    @Autowired OsebaDao OsebaDao;
    @Autowired ObjektDao ObjektDao;
    @RequestMapping(value = {"/registracija"}, method = RequestMethod.POST)
    public String Prijava(Model model,@RequestParam(value="imeP", required = true) String imeP, @RequestParam(value="ime", required=true) String ime, @RequestParam(value="priimek", required=true) String priimek,
           @RequestParam(value="mail", required = true) String mail, @RequestParam(value="geslo", required=true) String geslo, @RequestParam(value="uporabniskoIme", required=false) String uporabniskoIme) {

        Oseba oseba = new Oseba(ime,priimek,mail, uporabniskoIme, geslo);
        OsebaDao.addOseba(ime,priimek,mail,oseba.getUporabniskoIme(), geslo);
        ObjektDao.addObjekt(imeP);
        return "redirect:/index";

    }
}
