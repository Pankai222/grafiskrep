package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ServiceAmountController {
    @RequestMapping( "/service_amount" )
    public String serviceAmount() {
        return "service_amount";
    }

    @PostMapping( "/service_amount" )
    public String sendServiceAmount( String amount, HttpSession session ) {
        session.setAttribute( "amount", amount );
        return "redirect:service_order";
    }
}
