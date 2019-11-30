package dat19v2.projektgrafiskrep.grafiskrep.model;

public class Machine {

    private String type;
    private String brand;
    private String modelNr;
    private String serialNr;
    private String desc;

    public Machine() {
    }

    public Machine(String type, String brand, String modelNr, String serialNr, String desc) {
        this.type = type;
        this.brand = brand;
        this.modelNr = modelNr;
        this.serialNr = serialNr;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNr() {
        return modelNr;
    }

    public void setModelNr(String modelNr) {
        this.modelNr = modelNr;
    }

    public String getSerialNr() {
        return serialNr;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
