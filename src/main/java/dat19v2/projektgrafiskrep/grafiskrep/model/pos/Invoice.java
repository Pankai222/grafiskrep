package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.time.LocalDateTime;

public class Invoice {

    private String paymentInfo;
    private LocalDateTime paymentDate;
    private String Type;

    public Invoice() {
    }

    public Invoice(String paymentInfo, LocalDateTime paymentDate) {
        this.paymentInfo = paymentInfo;
        this.paymentDate = paymentDate;
    }

    //converts java.util.Date to java.sql.Date so it can be inserted into database
    //    Code written for using DATETIME in SQL Database.
//    public java.sql.Date convertDate(){
//        java.util.Date paymentDate = new java.util.Date();
//        return new java.sql.Date(paymentDate.getTime());
//    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getType() { return Type; }

    public void setType(String type) { Type = type; }
}