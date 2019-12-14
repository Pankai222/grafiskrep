package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ConfirmationController {
    @RequestMapping("/confirmation")
    public String confirmation(HttpSession httpSession, Model model){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        model.addAttribute("sale", sale);
        return "confirmation";
    }
}
