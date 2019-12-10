package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaleDAO {


    public void insert(Sale sale) {
        String sql = "INSERT INTO sales" + "(Date, TotalPrice)" +
                "VALUES (?,?)";
        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setString(1,sale.getDate().toString());
            ps.setInt(2,sale.getTotalPrice());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }
}
