package dat19v2.projektgrafiskrep.grafiskrep.model.repair;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;

import java.time.LocalDateTime;

public class Repair {
    private RepairType type;
    private Machine machine;
    private Customer customer;
    private LocalDateTime date;

    public Repair() {
    }

    public Repair(RepairType type, Machine machine, Customer customer, LocalDateTime date) {
        this.type = type;
        this.machine = machine;
        this.customer = customer;
        this.date = date;
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
}
