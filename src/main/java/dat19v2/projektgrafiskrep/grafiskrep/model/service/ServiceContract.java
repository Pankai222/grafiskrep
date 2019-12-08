package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.time.LocalDateTime;
import java.util.List;

public class ServiceContract {
    private List<Service> services;
    private Customer customer;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ServiceContract() {
    }

    public ServiceContract(List<Service> services, Customer customer, LocalDateTime startDate, LocalDateTime endDate) {
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
