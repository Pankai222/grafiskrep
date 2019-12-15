package dat19v2.projektgrafiskrep.grafiskrep.model.pos;


public class SalesInvoice extends Invoice{

    private Sale salesInfo;

    public SalesInvoice(String type, Sale salesInfo) {
        super(type);
        this.salesInfo = salesInfo;
    }

    public Sale getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(Sale salesInfo) {
        this.salesInfo = salesInfo;
    }
}
