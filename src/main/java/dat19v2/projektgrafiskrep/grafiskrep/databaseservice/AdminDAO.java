package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDAO {

    public void insert(Admin admin) {
        String sql = "INSERT INTO admin" + "(Password)" + "VALUES (?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, admin.getPassword());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
