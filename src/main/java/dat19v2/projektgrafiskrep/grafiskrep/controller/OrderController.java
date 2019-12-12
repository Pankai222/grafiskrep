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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class OrderController {
    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return new MachineDAO().selectAll();
    }

    @RequestMapping( "/order" )
    public String order()  {
        return "order";
    }

    @PostMapping( "/order" )
    // NOTE: maybe turn it into an Order object?
    public void sendOrder( String radioChoice, String machine, String firstName, String lastName, String phoneNr, String cvr,
                                  String email, String address, String postNr, String comment) {
        Customer customer = new Customer( cvr, ( firstName + lastName ), address, phoneNr, email );
        // NOTE: start and end date are set to null because GrafiskRep will decide when it will start and end with
        // the customer
        ServiceContract serviceContract = new ServiceContract( null, customer, null, null );
        ServiceContractOrder SCO = new ServiceContractOrder( serviceContract, LocalDateTime.now() );

        // TODO: ASK ABOUT DATABASE DESIGN, does idService and idMachineParts need to be primary key in the bridge
        // TODO: table serviceContracts_has_services?

        new CustomerDAO().insert( customer );
        new ServiceContractDAO().insert( serviceContract );
        new ServiceContractOrderDAO().insert( SCO );
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", radioChoice, machine, firstName, lastName, phoneNr,
                                                               cvr, email, address, postNr, comment );
    }
}
