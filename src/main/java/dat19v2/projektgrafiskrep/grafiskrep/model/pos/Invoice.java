package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.time.LocalDateTime;

public class Invoice {

    private String regNr;
    private String kontoNr;
    private LocalDateTime paymentDate;
    private String type;

    public Invoice() {
    }

    public Invoice(String type) {
        this.type = type;
        regNr = "1234";
        kontoNr = "112233445566";
        paymentDate = LocalDateTime.now().plusDays(30);
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String kontoNr) {
        this.kontoNr = kontoNr;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}