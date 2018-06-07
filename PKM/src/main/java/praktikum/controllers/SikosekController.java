package praktikum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import praktikum.Entities.Objekt;
import praktikum.Entities.Oseba;
import praktikum.db.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class SikosekController {


    @Autowired
    Tip_ObjektaDao Tip_ObjektaDao;
    @Autowired
    Tip_DogodkaDao Tip_DogodkaDao;
    @Autowired
    private JavaMailSender sender;

    @RequestMapping(value = {"/registracija"}, method = RequestMethod.GET)
    public String Prijava(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        List<String> tip_objekta = Tip_ObjektaDao.getAllTipObjekti();
        model.addAttribute("tip_objekta", tip_objekta);
        System.out.print(SecurityContextHolder.getContext().getAuthentication().getName());
        return "/registracija";
    }

    @RequestMapping(value = {"/dodajanjeDogodka"}, method = RequestMethod.GET)
    public String Dodaj(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        List<String> tip_dogodka = Tip_DogodkaDao.getAllTipiDogodka();
        model.addAttribute("tip_dogodka", tip_dogodka);
        String objekt = ObjektDao.getObjektByLoginedUser();

        model.addAttribute("objekt", objekt);
        return "/dodajanjeDogodka";
    }


    @Autowired
    OsebaDao OsebaDao;
    @Autowired
    ObjektDao ObjektDao;

    @RequestMapping(value = {"/registracija"}, method = RequestMethod.POST)
    public String Registracija(Model model, @RequestParam(value = "imeP", required = true) String imeP, @RequestParam(value = "lastnik", required = true) String lastnik,
                               @RequestParam(value = "mail", required = true) String mail, @RequestParam(value = "geslo", required = true) String geslo, @RequestParam(value = "uporabniskoIme", required = false) String uporabniskoIme,
                               @RequestParam(value = "naslov", required = true) String naslov, @RequestParam(value = "tip_Podjetja") String tip_objekta,
                               @RequestParam(value = "dolzina") double dolzina, @RequestParam(value = "sirina") double sirina) {
        Objekt objekt = new Objekt(imeP);
        ObjektDao.addObjekt(imeP, naslov, tip_objekta, dolzina, sirina);
        Oseba oseba = new Oseba(lastnik, mail, uporabniskoIme, geslo, ObjektDao.getObjektByNaziv(imeP).getNaziv());
        OsebaDao.addOseba(lastnik, mail, oseba.getUporabniskoIme(), geslo, ObjektDao.getObjektByNaziv(imeP).getId());
        OsebaDao.addUsers(oseba.getUporabniskoIme(), geslo);
        OsebaDao.addAuthority(oseba.getUporabniskoIme());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(mail);

            helper.setText("Uspešno ste se registrirali na strani Mestni Utrip.\n\n\nVaše uporabniško ime je: " + oseba.getUporabniskoIme() + "\nVaše geslo je: " + geslo + "\n\n\n" + "Hvala za zaupanje in upamo da vam bomo v veliko pomoč!");
            helper.setSubject("Mestni Utrip - Uspešna registracija!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sender.send(message);

        return "redirect:/index";

    }

//    @RequestMapping(value = {"/prijava"}, method = RequestMethod.POST)
//    public String Prijava(Model model , @RequestParam(value="uporabniskoime") String uporabniskoime, @RequestParam(value="geslo") String geslo){
//
////        Oseba o = OsebaDao.getOsebaByUsername(uporabniskoime);
////
////        if(o == null){
////            return "redirect:/index";
////        }
////        else{
////            if(geslo == o.getGeslo()){
////                return "redirect:/index2";
////            }
////            else{
////                return "redirect:/index";
////            }
////        }
//        return "redirect:/index";
//    }
}
