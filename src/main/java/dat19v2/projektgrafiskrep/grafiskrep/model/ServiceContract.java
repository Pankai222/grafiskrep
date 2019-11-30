package dat19v2.projektgrafiskrep.grafiskrep.model;

import java.time.LocalDate;
import java.util.List;

public class ServiceContract {
    private List<Service> services;
    private Customer customer;
    private int price;
    private LocalDate startDate;
    private LocalDate endDate;

    public ServiceContract() {
    }

    public ServiceContract(List<Service> services, Customer customer, int price, LocalDate startDate, LocalDate endDate) {
        this.services = services;
        this.customer = customer;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
