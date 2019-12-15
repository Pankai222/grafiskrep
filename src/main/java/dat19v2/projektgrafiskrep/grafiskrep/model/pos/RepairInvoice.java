package dat19v2.projektgrafiskrep.grafiskrep.model.pos;


public class RepairInvoice extends Invoice{
    private Sale repairInfo;

    public RepairInvoice(String type, Sale repairInfo) {
        super(type);
        this.repairInfo = repairInfo;
    }

    public Sale getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(Sale repairInfo) {
        this.repairInfo = repairInfo;
    }
}
