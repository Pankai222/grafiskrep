package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CheckoutController {
    @RequestMapping("/checkout")
    public String checkout(@ModelAttribute("sale") Sale sale, HttpSession httpSession){
        sale = (Sale) httpSession.getAttribute("sale");
        return "checkout";
    }
}
