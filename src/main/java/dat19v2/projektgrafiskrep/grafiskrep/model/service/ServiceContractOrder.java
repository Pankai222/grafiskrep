package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ServiceContractOrder {
    private LocalDateTime date;
    private ArrayList<Service> services;
    private Customer customer;

    public ServiceContractOrder() {
    }

    public ServiceContractOrder(LocalDateTime date, ArrayList<Service> services, Customer customer) {
        this.date = date;
        this.services = services;
        this.customer = customer;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
