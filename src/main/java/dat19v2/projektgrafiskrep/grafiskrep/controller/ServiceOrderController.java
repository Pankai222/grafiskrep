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
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
public class ServiceOrderController {
    @RequestMapping( "/service_order" )
    public String serviceOrder() {
        return "service_order";
    }

    @ModelAttribute( "serviceAmount" )
    public String getServiceAmount( HttpSession httpSession ) {
        String serviceAmount = (String) httpSession.getAttribute( "amount" );
        System.out.println( serviceAmount );
        return serviceAmount;
    }

    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return new MachineDAO().selectAll();
    }

    @PostMapping( "/service_order" )
    // NOTE: maybe turn it into an Order object?
    public void sendOrder( String machine1, String machine2, String machine3, String machine4,
                           String date1, String date2, String date3, String date4,
                           String name, String phoneNr, String cvr, String email, String address, String postNr, String comment ) {
        Customer customer = new Customer( cvr, name, address, phoneNr, email );

        // TODO: check for 'Ved ikke'
        // TODO: figure out DB stuff, then we are pretty much done
        ArrayList<Service> services = new ArrayList<>();
        // date, machine, machineParts

        ServiceContractOrder SCO = new ServiceContractOrder( LocalDateTime.now(), services, customer );

        new ServiceContractOrderDAO().insert( SCO );
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", machine1,machine2,machine3,machine4, date1,date2,date3,date4, name, phoneNr,
                                                               cvr, email, address, postNr, comment );
    }
}
