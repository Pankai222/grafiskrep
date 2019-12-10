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
        MachineDAO machineDAO = new MachineDAO();
        List<Machine> machines = machineDAO.selectAll();
        return machines;
    }

    @RequestMapping( "/order" )
    public String order()  {
        return "order";
    }

    @PostMapping( "/order" )
    public void sendServiceOrder() {

    }
}
