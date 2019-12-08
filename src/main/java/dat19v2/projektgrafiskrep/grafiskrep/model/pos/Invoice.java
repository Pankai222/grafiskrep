package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.util.Date;

public class Invoice {

    private String paymentInfo;
    private Date paymentDate;
    private String Type;

    public Invoice() {
    }

    public Invoice(String paymentInfo, Date paymentDate) {
        this.paymentInfo = paymentInfo;
        this.paymentDate = paymentDate;
    }

    //converts java.util.Date to java.sql.Date so it can be inserted into database
    public java.sql.Date convertDate(){
        java.util.Date paymentDate = new java.util.Date();
        return new java.sql.Date(paymentDate.getTime());
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getType() { return Type; }

    public void setType(String type) { Type = type; }
}