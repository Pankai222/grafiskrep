package dat19v2.projektgrafiskrep.grafiskrep.model;

public class Admin {
    private String password;

    public Admin() {
    }

    public Admin(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
