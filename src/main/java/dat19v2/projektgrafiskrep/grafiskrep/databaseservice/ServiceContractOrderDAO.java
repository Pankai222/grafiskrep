package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServiceContractOrderDAO {

    public void insert(ServiceContractOrder SCO) {
        String sql = "INSERT INTO serviceContractOrders" + "(Date)" + "VALUES(?)";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,SCO.getDate().toString());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
