package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private LocalDateTime date;
    private int totalPrice;
    private ArrayList<MachinePart> items;

    public Sale() {
        this.items = new ArrayList<>();
    }

    public Sale(int totalPrice, ArrayList<MachinePart> items) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Sale (LocalDateTime date, int totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calcTotalPrice(){
        totalPrice = 0;
        for (MachinePart part:
                items) {
            totalPrice += part.getPrice();
        }
    }
    public ArrayList<MachinePart> getItems() {
        return items;
    }

    public void setItems(ArrayList<MachinePart> items) {
        this.items = items;
    }

}
