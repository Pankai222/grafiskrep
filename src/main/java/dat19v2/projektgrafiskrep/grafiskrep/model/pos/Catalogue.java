package dat19v2.projektgrafiskrep.grafiskrep.model.pos;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.util.List;

public class Catalogue {
    private List<MachinePart> items;

    public Catalogue(List<MachinePart> items) {
        this.items = items;
    }

    public List<MachinePart> getItems() {
        return items;
    }

    public void setItems(List<MachinePart> items) {
        this.items = items;
    }
}
