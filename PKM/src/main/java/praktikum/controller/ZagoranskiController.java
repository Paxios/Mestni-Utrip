package praktikum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import praktikum.db.DogodekDao;
import praktikum.db.ObjektDao;

@Controller
public class ZagoranskiController {
    @Autowired
    ObjektDao objektDao;
    @Autowired
    DogodekDao dogodekDao;

    @Value("${welcome.message}")
    private String message = "Mestni utrip";

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", this.message);
        return "index";
    }
    @RequestMapping(value = { "/klubi" }, method = RequestMethod.GET)
    public String klubi(Model model) {
        model.addAttribute("klubi",objektDao.getAllObjekti());
        return "klubi";
    }
    @RequestMapping(value = { "/kultura" }, method = RequestMethod.GET)
    public String kultura(Model model) {
        model.addAttribute("kultura",objektDao.getAllObjekti());
        return "kultura";
    }
    @RequestMapping(value = { "/narava" }, method = RequestMethod.GET)
    public String narava(Model model) {
        model.addAttribute("narava",objektDao.getAllObjekti());
        return "narava";
    }
    @RequestMapping(value = { "/restavracije" }, method = RequestMethod.GET)
    public String restavracije(Model model) {
        model.addAttribute("restavracije",objektDao.getAllObjekti());
        return "restavracije";
    }
    @RequestMapping(value = { "/sport" }, method = RequestMethod.GET)
    public String sport(Model model) {
        model.addAttribute("sport",objektDao.getAllObjekti());
        return "sport";
    }
    @RequestMapping(value = { "/aktualno" }, method = RequestMethod.GET)
    public String aktualno(Model model) {
        model.addAttribute("aktualno",objektDao.getAllObjekti());
        return "aktualno";
    }

}