// skrevet af Andreas Wede Gustavsen med hjaelp fra Niklas Lund Brock

package dat19v2.projektgrafiskrep.grafiskrep.controller;

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
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

//Controller for the service_order page.
@Controller
public class ServiceOrderController {
    //    returns the service_order file, when /service_order is requested
    @RequestMapping( "/service_order" )
    public String serviceOrder() {
        return "service_order";
    }
//    adds the attribute "serviceamount" to the model
//    instantiates a serviceamount which is fetched from the httpsession and finally returned at the end of the method.
    @ModelAttribute( "serviceAmount" )
    public String getServiceAmount( HttpSession httpSession ) {
        return (String) httpSession.getAttribute( "amount" );
    }

    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return MachineDAO.selectAll();
    }

    @PostMapping( "/service_order" )
    public void sendOrder( HttpSession httpSession, String machine1Index,
                           String machine2Index, String machine3Index,
                           String machine4Index,
                           String date1, String date2, String date3, String date4,
                           String name, String phoneNr, String cvr, String email, String address, String postNr, String comment ) {
        Customer customer = new Customer( cvr, name, address, phoneNr, email );
        int serviceAmount =
                Integer.parseInt( (String)httpSession.getAttribute( "amount" ) );

        int machine1Int = 0;
        int machine2Int = 0;
        int machine3Int = 0;
        int machine4Int = 0;
        if ( machine1Index != null ) {
            machine1Int = Integer.parseInt(machine1Index);
        }
        if ( machine2Index != null ) {
             machine2Int = Integer.parseInt(machine2Index);
        }
        if ( machine3Index != null ) {
             machine3Int = Integer.parseInt(machine3Index);
        }
        if ( machine4Index != null ) {
            machine4Int = Integer.parseInt(machine4Index);
        }

        LocalDateTime date1Time = null;
        LocalDateTime date2Time = null;
        LocalDateTime date3Time = null;
        LocalDateTime date4Time = null;

        if ( date1 != null ) {
            date1Time = LocalDateTime.parse( date1 );
        }
        if ( date2 != null ) {
            date2Time = LocalDateTime.parse( date2 );
        }
        if ( date3 != null ) {
            date3Time = LocalDateTime.parse( date3 );
        }
        if ( date4 != null ) {
            date4Time = LocalDateTime.parse( date4 );
        }


        ArrayList<Service> services = new ArrayList<>();
        switch ( serviceAmount ) {
            case 1:
                services.add( new Service(date1Time, items().get(machine1Int)));
                break;
            case 2:
                services.add( new Service(date1Time,
                        items().get( machine1Int ) ) );
                services.add( new Service( date2Time,
                        items().get(machine2Int)));
                break;
            case 3:
                services.add( new Service(date1Time,
                        items().get( machine1Int ) ) );
                services.add( new Service( date2Time,
                        items().get(machine2Int)));
                services.add( new Service( date3Time,
                        items().get(machine3Int)));
                break;
            case 4:
                services.add( new Service(date1Time,
                        items().get( machine1Int ) ) );
                services.add( new Service( date2Time,
                        items().get(machine2Int)));
                services.add( new Service( date3Time,
                        items().get(machine3Int)));
                services.add( new Service( date4Time,
                        items().get(machine4Int)));
                break;
        }
        ServiceContractOrder SCO = new ServiceContractOrder( LocalDateTime.now(), services, customer );

        ServiceContractOrderDAO.insert( SCO );
        /*
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", machine1,machine2,machine3,machine4, date1,date2,date3,date4, name, phoneNr,
                                                               cvr, email, address, postNr, comment );
         */
    }
}
