//Skrevet af Frederik
package dat19v2.projektgrafiskrep.grafiskrep.controller;

import dat19v2.projektgrafiskrep.grafiskrep.databaseservice.*;
import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.repair.Repair;
import dat19v2.projektgrafiskrep.grafiskrep.model.repair.RepairType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
//Controller for the repairorder page.
@Controller
public class RepairOrderController {
//    returns the repair_order file, when /repair_order is requested
    @RequestMapping("/repair_order")
    public String repairOrder(){
        return "repair_order";
    }

    //Adds the model Machines, which returns an arraylist of machines from database, for use with thymeleaf.
    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return MachineDAO.selectAll();
    }

    //Adds the model repairtypes, which returns an arraylist of repairtypes from database, for use with thymeleaf.
    @ModelAttribute( "repairTypes" )
    ArrayList<RepairType> repairTypes() {
        return RepairTypeDAO.selectAll();
    }

    @PostMapping( "submit-order" )
    public String sendOrder(Model model, String repairDate, int repairtypeIndex, int machineIndex, String firstName,
                            String lastName, String phoneNr, String cvr,
                            String email, String address, String postNr, String comment) {

        Repair repair = new Repair(repairTypes().get(repairtypeIndex), items().get(machineIndex),
                new Customer(cvr, firstName+" "+lastName, address, phoneNr, email),
                LocalDateTime.parse(repairDate));


        //Running the method from our DAO, so that
        RepairOrdersDAO.insert(repair);

        return "/repair_order";
    }
}
