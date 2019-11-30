package dat19v2.projektgrafiskrep.grafiskrep.model;

public class Customer {
    private String cvr;
    private String name;
    private String address;
    private String phoneNr;
    private String email;

    public Customer() {
    }

    public Customer(String cvr, String name, String address, String phoneNr, String email) {
        this.cvr = cvr;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.email = email;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
