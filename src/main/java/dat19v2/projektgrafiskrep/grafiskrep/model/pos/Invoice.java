package dat19v2.projektgrafiskrep.grafiskrep.model.pos;
import java.time.LocalDate;

public class Invoice {

    private String paymentInfo;
    private LocalDate paymentDate;


    public Invoice() {
    }

    public Invoice(String paymentInfo, LocalDate paymentDate) {
        this.paymentInfo = paymentInfo;
        this.paymentDate = paymentDate;
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