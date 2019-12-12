package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.CustomerDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.MachineDAO;
import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.ServiceContractOrderDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.Service;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class RepairOrderController {

    @RequestMapping("/repair_order")
    public String repairOrder(){
        return "repair_order";
    }

    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return new MachineDAO().selectAll();
    }

    @PostMapping( "/repair_order" )
    // NOTE: maybe turn it into an Order object?
    public void sendOrder( String repairDate, String machine, String firstName, String lastName, String phoneNr, String cvr,
                           String email, String address, String postNr, String comment) {
        Customer customer = new Customer( cvr, ( firstName + lastName ), address, phoneNr, email );
        // NOTE: start and end date are set to null because GrafiskRep will decide when it will start and end with
        // the customer
        ArrayList<Service> services = new ArrayList<>();
        ServiceContractOrder SCO = new ServiceContractOrder(LocalDateTime.now(),
                services, customer );

        new CustomerDAO().insert( customer );
        new ServiceContractOrderDAO().insert( SCO );
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", repairDate, machine, firstName, lastName, phoneNr,
                cvr, email, address, postNr, comment );
    }
}