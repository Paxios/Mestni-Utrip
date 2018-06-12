package praktikum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import praktikum.Entities.FileUploadForm;
import praktikum.db.DogodekDao;
import praktikum.db.ObjektDao;
import praktikum.db.SlikaDao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ZagoranskiController {
    @Autowired
    ObjektDao objektDao;
    @Autowired
    DogodekDao dogodekDao;
    @Autowired
    SlikaDao slikaDao;

    @Value("${welcome.message}")
    private String message = "Mestni utrip";

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("message", this.message);
        return "index";
    }
    @RequestMapping(value = { "/klubi" }, method = RequestMethod.GET)
    public String klubi(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("klu", dogodekDao.getDogodekByFK(1));
        return "klubi";
    }
    @RequestMapping(value = { "/klubi" }, method = RequestMethod.POST)
    public String klubi(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("klu",dogodekDao.getDogodekByFKOrdered(1, preverjanje));
        return "klubi";
    }
    @RequestMapping(value = { "/restavracije" }, method = RequestMethod.GET)
    public String restavracije(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("res",dogodekDao.getDogodekByFK(2));
        return "restavracije";
    }
    @RequestMapping(value = { "/restavracije" }, method = RequestMethod.POST)
    public String restavracije(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("res",dogodekDao.getDogodekByFKOrdered(2, preverjanje));
        return "restavracije";
    }
    @RequestMapping(value = { "/narava" }, method = RequestMethod.GET)
    public String narava(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("nar",dogodekDao.getDogodekByFK(3));
        return "narava";
    }
    @RequestMapping(value = { "/narava" }, method = RequestMethod.POST)
    public String narava(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("nar",dogodekDao.getDogodekByFKOrdered(3, preverjanje));
        return "narava";
    }
    @RequestMapping(value = { "/kultura" }, method = RequestMethod.GET)
    public String kultura(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("kul",dogodekDao.getDogodekByFK(4));
        return "kultura";
    }
    @RequestMapping(value = { "/kultura" }, method = RequestMethod.POST)
    public String kultura(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("kul",dogodekDao.getDogodekByFKOrdered(4, preverjanje));
        return "kultura";
    }
    @RequestMapping(value = { "/sport" }, method = RequestMethod.GET)
    public String sport(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("spo",dogodekDao.getDogodekByFK(5));
        return "sport";
    }
    @RequestMapping(value = { "/sport" }, method = RequestMethod.POST)
    public String sport(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("spo",dogodekDao.getDogodekByFKOrdered(5, preverjanje));
        return "sport";
    }
    @RequestMapping(value = { "/aktualno" }, method = RequestMethod.GET)
    public String aktualno(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("akt",dogodekDao.getAllDogodki());
        return "aktualno";
    }
    @RequestMapping(value = { "/aktualno" }, method = RequestMethod.POST)
    public String aktualno(Model model, @RequestParam(value="preveri") String preverjanje) {
        model.addAttribute("akt",dogodekDao.getAllDogodkiOrdered(preverjanje));
        System.out.println(preverjanje);
        return "aktualno";
    }
    @RequestMapping(value ={ "/podrobnosti"}, method = RequestMethod.GET)
    public String Prijava(Model model, @RequestParam(value="id") int id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("pod", dogodekDao.getDogodekByID(id));
        model.addAttribute("sli", slikaDao.getSlikaByFK(id));
        return "podrobnosti";
    }

    @RequestMapping(value = {"/dodajanjeDogodka"}, method = RequestMethod.POST)
    public String DodajanjeDogodka(Model model, @RequestParam(value="naziv") String naziv, @RequestParam(value="vstopnina") double vstopnina,
                                   @RequestParam(value="kapaciteta") int kapaciteta, @RequestParam(value="tip") String tip, @RequestParam(value="opis") String opis, @RequestParam(value="imeObjekta") String imeObjekta,
                                   @RequestParam(value="datumZacetka") String datumZacetka, @RequestParam(value="uraZacetka") String uraZacetka, @RequestParam(value="datumKonca") String datumKonca,
                                   @RequestParam(value="uraKonca") String uraKonca, @ModelAttribute("uploadForm") FileUploadForm uploadForm) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datumZacetkaa = LocalDate.parse(datumZacetka,formatter);
        LocalDate datumKoncaa = LocalDate.parse(datumKonca,formatter);
        LocalTime uraZac = LocalTime.parse(uraZacetka);
        LocalTime uraKon = LocalTime.parse(uraKonca);
        dogodekDao.addDogodek(naziv, vstopnina, kapaciteta, opis,datumZacetkaa,uraZac,datumKoncaa,uraKon,tip,imeObjekta);

        try{
            List<MultipartFile> files = uploadForm.getFiles();
            List<String> fileNames = new ArrayList<String>();
            if(null != files && files.size() > 0) {
                for (MultipartFile multipartFile : files) {
                    String fileName;
                    fileName   = multipartFile.getOriginalFilename();
                    fileNames.add(fileName);
                    slikaDao.save(multipartFile,dogodekDao.getIdDogodka(naziv));
                }

            }
            model.addAttribute("files", fileNames);

        }catch (NullPointerException e){
            System.out.println("Nobena slika ni bila dodana.");
        }
        return "redirect:/index";
    }
}