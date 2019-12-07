package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
// Selecting all content from table and adding to customers arraylist via query resultset
    public List<Customer> selectAll() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection con = DatabaseAdapter.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Customer cust = new Customer();
                    cust.setCvr(rs.getString("CVR"));
                    cust.setName(rs.getString("Name"));
                    cust.setAddress(rs.getString("Address"));
                    cust.setPhoneNr(rs.getString("Phone"));
                    cust.setEmail(rs.getString("Email"));
                    customers.add(cust);
                }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return customers;
    }
    // method for inserting shit into customers table
    public void insert(Customer customer) {
        String sql = "INSERT INTO customers" + "(CVR, Name, Address, Phone, Email)" + "VALUES (?," +
                "?,?,?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
             {
                 // initiliazing each row in table except for id (that shit is autogenerated)
                 ps.setString(1, customer.getCvr());
                 ps.setString(2, customer.getName());
                 ps.setString(3, customer.getAddress());
                 ps.setString(4, customer.getPhoneNr());
                 ps.setString(5, customer.getEmail());
                 ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    public void delete(String string) {
        String sql = "DELETE FROM customers WHERE CVR = ?";
        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, string);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void update(String string2, String string3) {
        String sql = "UPDATE customers " +
                "SET Name = ? " +
                "WHERE CVR = ?";
        try (Connection con =
                     DatabaseAdapter.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, string2);
            ps.setString(2, string3);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void select(String string) {
        String sql = "SELECT CVR, Name, Address, Phone, Email FROM customers WHERE CVR = ?";

        try (Connection con =
                DatabaseAdapter.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, string);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
