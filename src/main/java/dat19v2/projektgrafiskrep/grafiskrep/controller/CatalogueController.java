package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Catalogue;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class CatalogueController {

    @ModelAttribute("catalogue")
    public Catalogue catalogue(){
        Catalogue catalogue = new Catalogue();
        //        Start of No DB access code
        catalogue.getItems().add(new MachinePart("Part 1", "Brand 1", "PartNr 1", "Description 1", 100));
        catalogue.getItems().add(new MachinePart("Part 2", "Brand 2", "PartNr 2", "Description 2", 150));
        catalogue.getItems().add(new MachinePart("Part 3", "Brand 3", "PartNr 3", "Description 3", 175));
        catalogue.getItems().add(new MachinePart("Part 4", "Brand 4", "PartNr 4", "Description 4", 201));
        catalogue.getItems().add(new MachinePart("Part 5", "Brand 5", "PartNr 5", "Description 5", 509));
        catalogue.getItems().add(new MachinePart("Part 6", "Brand 6", "PartNr 6", "Description 6", 1000));
        //        End of No DB access code
        return catalogue;
    }
//    Will use this code later when the number of parts is unknown
//    @ModelAttribute("items")
//    public ArrayList<MachinePart> items(){
//        Catalogue catalogue = new Catalogue();
//    DATABASE SELECTALL HERE
//        return catalogue.getItems();
//    }
    @ModelAttribute("sale")
    public Sale sale(){
        Sale sale = new Sale();
        return sale;
    }

    @RequestMapping("/catalogue")
    public String catalogue(@ModelAttribute("catalogue") Catalogue catalogue, @ModelAttribute("sale") Sale sale, HttpSession httpSession){
        httpSession.setAttribute("sale", new Sale());
        httpSession.setAttribute("catalogue", catalogue);
        return "catalogue";
    }

    @PostMapping ("add-to-cart")
    public String addToCart(@ModelAttribute("catalogue") Catalogue catalogue, Model model, HttpSession httpSession, int itemIndex){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        sale.getItems().add(catalogue.getItems().get(itemIndex));
        sale.calcTotalPrice();
        model.addAttribute("sale", sale);
        model.addAttribute("catalogue", httpSession.getAttribute("catalogue"));
        httpSession.setAttribute("sale", sale);
        return "catalogue";
    }

}

