package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.MachineDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.MachinePartDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
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
        catalogue.setItems(new MachinePartDAO().selectAll());
        return catalogue;
    }

    @ModelAttribute("items")
    public ArrayList<MachinePart> items(){
        return new MachinePartDAO().selectAll();
    }

    @ModelAttribute("machines")
    public ArrayList<Machine> machines(){
        return new MachineDAO().selectAll();
    }

    @ModelAttribute("sale")
    public Sale sale(){
        return new Sale();
    }

    @RequestMapping("/catalogue")
    public String catalogue(@ModelAttribute("catalogue") Catalogue catalogue, @ModelAttribute("sale") Sale sale, @ModelAttribute("machines") ArrayList<Machine> machines, HttpSession httpSession){
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

