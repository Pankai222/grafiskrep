package dat19v2.projektgrafiskrep.grafiskrep.model;

import java.util.List;

public class Repair {
    private int price;
    private RepairType type;
    private Machine machine;
    private List<MachinePart> parts;

    public Repair() {
    }

    public Repair(int price, RepairType type, Machine machine, List<MachinePart> parts) {
        this.price = price;
        this.type = type;
        this.machine = machine;
        this.parts = parts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<MachinePart> getParts() {
        return parts;
    }

    public void setParts(List<MachinePart> parts) {
        this.parts = parts;
    }
}
