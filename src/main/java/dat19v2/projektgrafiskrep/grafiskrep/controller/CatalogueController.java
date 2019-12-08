package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Catalogue;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CatalogueController {

    @RequestMapping("/catalogue")
    public String catalogue(Model model, HttpSession httpSession){
//        Start of No DB code
        Catalogue catalogue = new Catalogue();
        catalogue.getItems().add(new MachinePart("Part 1", "Brand 1", "PartNr 1", "Description 1", 6969));
        catalogue.getItems().add(new MachinePart("Part 2", "Brand 2", "PartNr 2", "Description 2", 6969));
        catalogue.getItems().add(new MachinePart("Part 3", "Brand 3", "PartNr 3", "Description 3", 6969));
        catalogue.getItems().add(new MachinePart("Part 4", "Brand 4", "PartNr 4", "Description 4", 6969));
        catalogue.getItems().add(new MachinePart("Part 5", "Brand 5", "PartNr 5", "Description 5", 6969));
        catalogue.getItems().add(new MachinePart("Part 6", "Brand 6", "PartNr 6", "Description 6", 6969));
//        End of No DB code

//        Adding to model for thymeleaf and httpSession for use in other methods.
        httpSession.setAttribute("sale", new Sale());
        httpSession.setAttribute("catalogue", catalogue);
        model.addAttribute("catalogue", catalogue);
        model.addAttribute("sale", new Sale());
        return "catalogue";
    }

    @PostMapping ("add-to-cart")
    public String addToCart(Model model, HttpSession httpSession, MachinePart machinePart){
//        TODO Faa action til at sende et machinePart thymeleaf object tilbage fra html
        System.out.println(machinePart.toString());
        Sale sale = (Sale) httpSession.getAttribute("sale");
        sale.getItems().add(machinePart);
        sale.calcTotalPrice();
        model.addAttribute("sale", sale);
        model.addAttribute("catalogue", httpSession.getAttribute("catalogue"));
        httpSession.setAttribute("sale", sale);
        return "catalogue";
    }
}

