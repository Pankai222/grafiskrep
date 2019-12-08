package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceContract {
    private ArrayList<MachinePart> services;
    private Customer customer;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ServiceContract() {
    }

    public ServiceContract(ArrayList<MachinePart> services, Customer customer, LocalDateTime startDate, LocalDateTime endDate) {
        this.services = services;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<MachinePart> getServices() {
        return services;
    }

    public void setServices(ArrayList<MachinePart> services) {
        this.services = services;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
