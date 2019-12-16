package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.CustomerDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.MachineDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.ServiceContractDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.ServiceContractOrderDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.Service;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContract;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class ServiceOrderController {
    @RequestMapping( "/service_order" )
    public String serviceOrder( HttpSession httpSession, Model model ) {
        String serviceAmount = (String) httpSession.getAttribute( "amount" );
        model.addAttribute( "serviceAmount", serviceAmount );
        System.out.println( serviceAmount );
        return "service_order";
    }

    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return new MachineDAO().selectAll();
    }

    @PostMapping( "/service_order" )
    // NOTE: maybe turn it into an Order object?
    public void sendOrder( String machine, String name, String phoneNr, String cvr, String email, String address, String postNr, String comment ) {
        Customer customer = new Customer( cvr, name, address, phoneNr, email );
        // NOTE: start and end date are set to null because GrafiskRep will decide when it will start and end with
        // the customer
        ArrayList<Service> services = new ArrayList<>();
        ServiceContractOrder SCO = new ServiceContractOrder( LocalDateTime.now(), services, customer );

        new CustomerDAO().insert( customer );
        new ServiceContractOrderDAO().insert( SCO );
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s\n", machine, name, phoneNr,
                                                               cvr, email, address, postNr, comment );
    }
}
