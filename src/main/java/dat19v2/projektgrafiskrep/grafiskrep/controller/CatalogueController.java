package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CatalogueController {

    @RequestMapping("/catalogue")
    public String catalogue(Model model, HttpSession httpSession){
        return "catalogue";
    }

    @PostMapping ("add-to-cart")
    public String addToCart(Model model, HttpSession httpSession){
        return null;
    }
}

