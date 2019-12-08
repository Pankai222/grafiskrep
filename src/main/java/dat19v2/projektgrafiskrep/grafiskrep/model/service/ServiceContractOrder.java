package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import java.time.LocalDateTime;

public class ServiceContractOrder {
    private ServiceContract serviceContract;
    private LocalDateTime date;

    public ServiceContractOrder() {
    }

    public ServiceContractOrder(ServiceContract serviceContract, LocalDateTime orderDate) {
        this.serviceContract = serviceContract;
        this.date = orderDate;
    }

    public ServiceContract getServiceContract() {
        return serviceContract;
    }

    public void setServiceContract(ServiceContract serviceContract) {
        this.serviceContract = serviceContract;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
