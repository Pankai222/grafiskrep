package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.time.LocalDateTime;

public class RepairInvoice extends Invoice{
    private Sale repairInfo;

    public RepairInvoice() {
    }

    public RepairInvoice(Sale repairInfo) {
        this.repairInfo = repairInfo;
    }

    public RepairInvoice(String paymentInfo, LocalDateTime paymentDate, Sale repairInfo) {
        super(paymentInfo, paymentDate);
        this.repairInfo = repairInfo;
    }

    public Sale getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(Sale repairInfo) {
        this.repairInfo = repairInfo;
    }
}
