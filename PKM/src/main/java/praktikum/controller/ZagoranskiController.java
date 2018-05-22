package praktikum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import praktikum.Customer;
import praktikum.CustomerRepository;


@Controller
public class ZagoranskiController {
    @Autowired
    CustomerRepository repository;


    @Value("${welcome.message}")
    private String message = "Jebela cesta";

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", this.message);
        return "index";
    }
    @RequestMapping(value = { "/klubi" }, method = RequestMethod.GET)
    public String klubi(Model model) {
        model.addAttribute("message", this.message);
        return "klubi";
    }
    @RequestMapping(value = { "/kultura" }, method = RequestMethod.GET)
    public String kultura(Model model) {
        model.addAttribute("message", this.message);
        return "kultura";
    }
    @RequestMapping(value = { "/narava" }, method = RequestMethod.GET)
    public String narava(Model model) {
        model.addAttribute("message", this.message);
        return "narava";
    }
    @RequestMapping(value = { "/restavracije" }, method = RequestMethod.GET)
    public String restavracije(Model model) {
        model.addAttribute("message", this.message);
        return "restavracije";
    }
    @RequestMapping(value = { "/znamenitosti" }, method = RequestMethod.GET)
    public String znamenitosti(Model model) {
        model.addAttribute("message", this.message);
        return "znamenitosti";
    }

    @RequestMapping("/save")
    public String process(){
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }

    @RequestMapping("/findall")
    @ResponseBody
    public String findAll(){
        String result = "<html>";

        for(Customer cust : repository.findAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }


    @RequestMapping("/findbylastname")
    @ResponseBody
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(Customer cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}