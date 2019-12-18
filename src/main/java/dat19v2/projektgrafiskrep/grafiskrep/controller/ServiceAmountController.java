package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//Controller for the service amount page. returns the html file.
@Controller
public class ServiceAmountController {
    //    returns the service_amount file, when /service_amount is requested
    @RequestMapping( "/service_amount" )
    public String serviceAmount() {
        return "service_amount";
    }
//A postmapping annotation which takes in the amount chosen on the page and saves it to the httpsession
    @PostMapping( "/service_amount" )
    public String sendServiceAmount( String amount, HttpSession session ) {
        session.setAttribute( "amount", amount );
        return "redirect:service_order";
    }
}
