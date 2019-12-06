package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
// Selecting all content from table and adding to arraylist customers
    public List<Customer> select() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection con = DatabaseAdapter.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {


        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

    }
    public void insert() {
        String sql = "SELECT "
    }


    public void delete() {

    }

    public void update() {

    }

    public void selectAll() {

    }
}
