package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import java.time.LocalDateTime;

public class Invoice {

    private String regNr;
    private String kontoNr;
    private LocalDateTime paymentDate;
    private Sale saleInfo;

    public Invoice() {
    }

    public Invoice(Sale saleInfo) {
        regNr = "1234";
        kontoNr = "112233445566";
        paymentDate = LocalDateTime.now().plusDays(30);
        this.saleInfo = saleInfo;
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


    public Sale getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(Sale saleInfo) {
        this.saleInfo = saleInfo;
    }
}