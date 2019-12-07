package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Sale {
    private Date date;
    private int total;
    private List<MachinePart> items;

    public Sale() {
    }

    public Sale(Date date, int total, List<MachinePart> items) {
        this.date = date;
        this.total = total;
        this.items = items;
    }

    public java.sql.Date convertDate() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Date(date.getTime());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MachinePart> getItems() {
        return items;
    }

    public void setItems(List<MachinePart> items) {
        this.items = items;
    }
}
