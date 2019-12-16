package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.SaleDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Invoice;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class ConfirmationController {
    //  Adds the model saleitems, which returns an arraylist of machineparts, for use with thymeleaf.
    @ModelAttribute("saleitems")
    public ArrayList<MachinePart> saleitems (HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        return sale.getItems();
    }

    //  The action called when the customer has filled in info on checkout page, which then returns the confirmation view.
    //  The sale is retrieved from httpsession and the current datetime is added, then an invoice is created with the sale
    //  object. The sale is inserted into the database.
    @PostMapping("submit-sale")
    public String submitSale(Model model, Customer customer, HttpSession httpSession){
        Sale sale = (Sale) httpSession.getAttribute("sale");
        sale.setCustomer(customer);
        sale.setDate(LocalDateTime.now());
        Invoice invoice = new Invoice(sale);
        httpSession.setAttribute("invoice", invoice);
        model.addAttribute("invoice", invoice);
        SaleDAO saleDAO = new SaleDAO();
        saleDAO.insert(sale);
        return "/confirmation";
    }
}
