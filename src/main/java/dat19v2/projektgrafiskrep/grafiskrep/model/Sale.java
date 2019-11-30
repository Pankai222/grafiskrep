package dat19v2.projektgrafiskrep.grafiskrep.model;

import java.time.LocalDate;
import java.util.List;

public class Sale {
    private LocalDate date;
    private int total;
    private List<MachinePart> items;

    public Sale() {
    }

    public Sale(LocalDate date, int total, List<MachinePart> items) {
        this.date = date;
        this.total = total;
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
