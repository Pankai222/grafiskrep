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
             PreparedStatement customerPS = con.prepareStatement(sql1);
             PreparedStatement salePS = con.prepareStatement(sql2))
        {

            customerPS.setString(1,sale.getCustomer().getCvr());
            customerPS.setString(2,sale.getCustomer().getName());
            customerPS.setString(3,sale.getCustomer().getAddress());
            customerPS.setString(4,sale.getCustomer().getPhoneNr());
            customerPS.setString(5,sale.getCustomer().getEmail());
            customerPS.executeUpdate();

            salePS.setString(1,sale.getDate().toString());
            salePS.setInt(2,sale.getTotalPrice());
            salePS.executeUpdate();

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }
}
