package praktikum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import praktikum.Customer;
import praktikum.CustomerRepository;
import praktikum.Entities.Oseba;
import praktikum.Entities.Objekt;
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


    @Autowired OsebaDao OsebaDao;
    @Autowired ObjektDao ObjektDao;
    @RequestMapping(value = {"/registracija"}, method = RequestMethod.POST)
    public String Registracija(Model model,@RequestParam(value="imeP", required = true) String imeP, @RequestParam(value="lastnik", required=true) String lastnik,
           @RequestParam(value="mail", required = true) String mail, @RequestParam(value="geslo", required=true) String geslo, @RequestParam(value="uporabniskoIme", required=false) String uporabniskoIme) {

        Objekt objekt = new Objekt(imeP);
        Oseba oseba = new Oseba(lastnik,mail, uporabniskoIme, geslo, objekt.getNaziv());
        OsebaDao.addOseba(lastnik,mail,oseba.getUporabniskoIme(), geslo);
        ObjektDao.addObjekt(imeP);
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
}
