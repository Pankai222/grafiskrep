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

//Controller for the catalogue page.
@Controller
public class CatalogueController {

    //  Adds the model catalogue, which creates a catalogue object and sets the items to an arraylist of machineparts
    //  from database, for use with thymeleaf.
    @ModelAttribute("catalogue")
    public Catalogue catalogue(){
        Catalogue catalogue = new Catalogue();
        catalogue.setItems(new MachinePartDAO().selectAll());
        return catalogue;
    }
    //  Adds the model items, which returns an arraylist of machineparts from database, for use with thymeleaf.
    @ModelAttribute("items")
    public ArrayList<MachinePart> items(){
        return new MachinePartDAO().selectAll();
    }
    //  Adds the model machines, which returns an arraylist of machines from database, for use with thymeleaf.
    @ModelAttribute("machines")
    public ArrayList<Machine> machines(){
        return new MachineDAO().selectAll();
    }
    //    Adds the model sale, which returns a new sale object.
    @ModelAttribute("sale")
    public Sale sale(){
        return new Sale();
    }
    //    Sets two httpsession attributes. One to a new sale, and one adds the catalogue when the catalogue page is visited.
    @RequestMapping("/catalogue")
    public String catalogue(@ModelAttribute("catalogue") Catalogue catalogue, @ModelAttribute("sale") Sale sale, @ModelAttribute("machines") ArrayList<Machine> machines, HttpSession httpSession){
        httpSession.setAttribute("sale", new Sale());
        httpSession.setAttribute("catalogue", catalogue);
        return "catalogue";
    }
    //    This method is what enables the catalogue view to add machinepart items to a cart.
    //    The page is reloaded each time, as the client needs to connect to server, to get the updated sale object.
    @PostMapping ("add-to-cart")
    public String addToCart(@ModelAttribute("catalogue") Catalogue catalogue, Model model,
                            HttpSession httpSession, int itemIndex){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        sale.getItems().add(catalogue.getItems().get(itemIndex));
        sale.calcTotalPrice();
        model.addAttribute("sale", sale);
        httpSession.setAttribute("sale", sale);
        return "catalogue";
    }

}

