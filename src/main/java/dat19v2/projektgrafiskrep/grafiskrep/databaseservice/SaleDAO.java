package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaleDAO {


    public void insert(Sale sale) {
        String sql1 = "INSERT INTO customers" + "(CVR, Name, Address, Phone, Email)" + "VALUES" +
                "(?,?,?,?,?)";
        String sql2 = "INSERT INTO sales" + "(Date, TotalPrice, customers_idcustomers)" +
                "VALUES (?,?, LAST_INSERT_ID())";
        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement sp = con.prepareStatement(sql1);
             PreparedStatement ps = con.prepareStatement(sql2))
        {

            sp.setString(1,sale.getCustomer().getCvr());
            sp.setString(2,sale.getCustomer().getName());
            sp.setString(3,sale.getCustomer().getAddress());
            sp.setString(4,sale.getCustomer().getPhoneNr());
            sp.setString(5,sale.getCustomer().getEmail());
            sp.executeUpdate();

            ps.setString(1,sale.getDate().toString());
            ps.setInt(2,sale.getTotalPrice());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }
}
