package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private LocalDateTime date;
    private int total;
    private List<MachinePart> items;

    public Sale() {
    }

    public Sale(int total, List<MachinePart> items) {
        this.total = total;
        this.items = items;
    }

//    Code written for using DATETIME in SQL Database.
//    public LocalDateTime convertDate() {
//        java.util.Date date = new java.util.Date();
//        System.out.println(new java.sql.Date(date.getTime()));
//        return new java.sql.Date(date.getTime());
//    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
