package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CheckoutController {

    @ModelAttribute("saleitems")
    public ArrayList<MachinePart> saleitems (HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        return sale.getItems();

    }

    @RequestMapping("/checkout")
    public String checkout(Model model, HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        model.addAttribute("sale", sale);
        return "checkout";
    }

    @PostMapping("submit-sale")
    public String submitSale(Sale sale, Customer customer, HttpSession httpSession){
        httpSession.setAttribute("sale", sale);
        httpSession.setAttribute("customer", customer);

        return "confirmation";
    }
}

