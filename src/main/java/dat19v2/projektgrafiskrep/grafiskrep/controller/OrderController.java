package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.MachineDAO;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @ModelAttribute( "items" )
    List<Machine> items() {
        //List<Machine> machines = machineDAO.selectAll();

        //NO DB KODE, no machines in DB so added them myself
        MachineDAO machineDAO = new MachineDAO();
        List<Machine> machines = new ArrayList<>();

        machines.add(new Machine("Xeox","SejBrand", "x1x1x1x1","Flot printer"));
        machines.add(new Machine("Etmaerke","FlotBrand", "x2x2x2x2","Flot Bogmaskine"));
        machines.add(new Machine("Andetmaerke","TramperBrand", "x3x3x3x3","Flot Maskine"));
        machines.add(new Machine("Mikaelsmor","DunnoBrand", "x4x4x4x4","Flot Mikaels mor"));

        return machines;
    }

    @RequestMapping( "/order" )
    public String order()  {
        return "order";
    }

    @PostMapping( "/order" )
    // NOTE: maybe turn it into an Order object?
    public void sendOrder( String radioChoice, String machine, String firstName, String lastName, String cvr,
                                  String email, String address, String postNr, String comment) {
        System.out.format( "%s, %s, %s, %s, %s, %s, %s, %s, %s\n", radioChoice, machine, firstName, lastName,
                                                               cvr, email, address, postNr, comment );
    }
}
