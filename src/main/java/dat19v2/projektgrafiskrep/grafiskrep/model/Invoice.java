package dat19v2.projektgrafiskrep.grafiskrep.model;

import java.time.LocalDate;

public class Invoice {

    private Order orderInfo;
    private String paymentInfo;
    private LocalDate paymentDate;

    public Invoice() {
    }

    public Invoice(Order orderInfo, String paymentInfo, LocalDate paymentDate) {
        this.orderInfo = orderInfo;
        this.paymentInfo = paymentInfo;
        this.paymentDate = paymentDate;
    }

    public Order getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Order orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
