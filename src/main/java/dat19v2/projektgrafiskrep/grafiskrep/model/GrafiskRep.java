package dat19v2.projektgrafiskrep.grafiskrep.model;

public class GrafiskRep {
    private String cvr;
    private String address;
    private String phoneNr;
    private String email;

    public GrafiskRep(String cvr, String address, String phoneNumber, String email) {
        this.cvr = cvr;
        this.address = address;
        this.phoneNr = phoneNumber;
        this.email = email;
    }

    public GrafiskRep() {
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
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
