package dat19v2.projektgrafiskrep.grafiskrep.model.service;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceContract {
    private ServiceContractOrder SCO;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public ServiceContract() {
    }

    public ServiceContract(ServiceContractOrder SCO, LocalDateTime startDate,
                           LocalDateTime endDate) {
        this.SCO = SCO;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ServiceContractOrder getSCO() { return SCO; }

    public void setSCO(ServiceContractOrder SCO) { this.SCO = SCO; }

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
