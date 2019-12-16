package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Repair {
    private int price;
    private RepairType type;
    private Machine machine;
    private ArrayList<MachinePart> parts;
    private Customer customer;
    private LocalDateTime date;

    public Repair() {
    }

    public Repair(int price, RepairType type, Machine machine, ArrayList<MachinePart> parts, Customer customer, LocalDateTime date) {
        this.type = type;
        this.machine = machine;
        this.parts = parts;
        this.customer = customer;
        this.date = date;
        this.price = calcPrice();
    }

    private int calcPrice(){
        int partTotalPrice = 0;
        for (MachinePart part:
             parts) {
            partTotalPrice =+ part.getPrice();
        }
        return type.getPrice() + partTotalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<MachinePart> getParts() {
        return parts;
    }

    public void setParts(ArrayList<MachinePart> parts) {
        this.parts = parts;
    }
}
