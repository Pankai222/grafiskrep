package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import java.time.LocalDate;

public class ServiceContractOrder {
    private ServiceContract serviceContract;
    private LocalDate date;

    public ServiceContractOrder() {
    }

    public ServiceContractOrder(ServiceContract serviceContract, LocalDate orderDate) {
        this.serviceContract = serviceContract;
        this.date = orderDate;
    }

    public ServiceContract getServiceContract() {
        return serviceContract;
    }

    public void setServiceContract(ServiceContract serviceContract) {
        this.serviceContract = serviceContract;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
