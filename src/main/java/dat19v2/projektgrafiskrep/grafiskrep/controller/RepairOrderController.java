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

@Controller
public class RepairOrderController {

    @RequestMapping("/repair_order")
    public String repairOrder(){
        return "repair_order";
    }

    //Adds the model Machines, which returns an arraylist of machines from database, for use with thymeleaf.
    @ModelAttribute( "items" )
    ArrayList<Machine> items() {
        return new MachineDAO().selectAll();
    }

    //Adds the model repairtypes, which returns an arraylist of repairtypes from database, for use with thymeleaf.
    @ModelAttribute( "repairTypes" )
    ArrayList<RepairType> repairTypes() {
        return new RepairTypeDAO().selectAll();
    }


    @PostMapping( "submit-order" )
    public String sendOrder(Model model, String repairDate, int repairtypeIndex, int machineIndex, String firstName, String lastName, String phoneNr, String cvr,
                            String email, String address, String postNr, String comment) {

        Customer customer = new Customer(cvr, firstName+" "+lastName, address, phoneNr, email);

        RepairType repairType = repairTypes().get(repairtypeIndex);

        Machine machine = items().get(machineIndex);
        Repair repair = new Repair(repairType, machine, customer, LocalDateTime.parse(repairDate));


        RepairOrdersDAO repairOrdersDAO = new RepairOrdersDAO();

        //Running the method from our DAO, so that
        repairOrdersDAO.insert(repair);

        return "/repair_order";
    }
}
