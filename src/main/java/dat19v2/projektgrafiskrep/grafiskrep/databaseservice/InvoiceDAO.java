package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDAO {

//    TODO Fix date issue
    public void insert(Invoice invoice) {
        String sql = "INSERT INTO invoice" + "(PaymentInfo, PaymentDate, Type)" +
                "VALUES (?," +
                "?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setString(1, invoice.getPaymentInfo());
            ps.setString(2, invoice.getPaymentDate().toString());
            ps.setString(3, invoice.getType());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }

}
