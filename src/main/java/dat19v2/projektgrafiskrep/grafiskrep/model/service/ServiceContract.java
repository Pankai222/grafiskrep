package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.time.LocalDate;
import java.util.List;

public class ServiceContract {
    private List<Service> services;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public ServiceContract() {
    }

    public ServiceContract(List<Service> services, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.services = services;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
