package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<ServiceContractOrder> selectAll() {
        List<ServiceContractOrder> serviceOrderList = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMERS";
        try (Connection con = DatabaseAdapter.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ServiceContractOrder SVO = new ServiceContractOrder();


            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return serviceOrderList;
    }
}
