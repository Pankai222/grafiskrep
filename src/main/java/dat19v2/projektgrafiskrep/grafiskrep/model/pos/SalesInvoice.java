package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.util.Date;

public class SalesInvoice extends Invoice{

    private Sale salesInfo;

    public SalesInvoice() {
    }

    public SalesInvoice(Sale salesInfo) {
        this.salesInfo = salesInfo;
    }

    public SalesInvoice(String paymentInfo, Date paymentDate, Sale salesInfo) {
        super(paymentInfo, paymentDate);
        this.salesInfo = salesInfo;
    }

    public Sale getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(Sale salesInfo) {
        this.salesInfo = salesInfo;
    }
}
