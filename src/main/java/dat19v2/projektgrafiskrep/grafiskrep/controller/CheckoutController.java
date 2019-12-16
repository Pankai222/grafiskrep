package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CheckoutController {
    //  Adds the model saleitems, which returns an arraylist of machineparts, for use with thymeleaf.
    @ModelAttribute("saleitems")
    public ArrayList<MachinePart> saleitems (HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        return sale.getItems();
    }
    //  returns the checkout view when /checkout is visited.
    //  Gets the sale from httpsession and adds it to model again, to display it on checkout view.
    @RequestMapping("/checkout")
    public String checkout(Model model, HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        model.addAttribute("sale", sale);
        return "checkout";
    }

}

