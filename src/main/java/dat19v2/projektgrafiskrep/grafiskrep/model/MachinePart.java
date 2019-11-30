package dat19v2.projektgrafiskrep.grafiskrep.model;

public class MachinePart {

    private String name;
    private String brand;
    private String partNr;
    private String desc;
    private int price;

    public MachinePart(String name, String brand, String partNr, String desc, int price) {
        this.name = name;
        this.brand = brand;
        this.partNr = partNr;
        this.desc = desc;
        this.price = price;
    }

    public MachinePart() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPartNr() {
        return partNr;
    }

    public void setPartNr(String partNr) {
        this.partNr = partNr;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
