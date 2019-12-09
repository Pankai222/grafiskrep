package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private ArrayList<MachinePart> items;


    public Catalogue() {
        items = new ArrayList<MachinePart>();
    }

    public Catalogue(ArrayList<MachinePart> items) {
        this.items = items;
    }

    public ArrayList<MachinePart> getItems() {
        return items;
    }

    public void setItems(ArrayList<MachinePart> items) {
        this.items = items;
    }
}
