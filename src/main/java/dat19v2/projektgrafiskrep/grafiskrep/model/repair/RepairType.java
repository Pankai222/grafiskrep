package dat19v2.projektgrafiskrep.grafiskrep.model.repair;

public class RepairType {
    private String name;
    private int price;

    public RepairType() {
    }

    public RepairType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
