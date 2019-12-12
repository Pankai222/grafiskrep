package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.CustomerDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.SaleDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){

        Sale s = new Sale(LocalDateTime.now(), 200);
        s.setCustomer(new Customer("1234", "Lol", "hejsa", "hdawdo", "woop"));
        SaleDAO sf = new SaleDAO();
        sf.insert(s);
        return "index";
    }
}
