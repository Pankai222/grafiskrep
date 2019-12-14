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
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    /* Not sure if this is viable
    public List<ServiceContractOrder> selectAll() {
        List<ServiceContractOrder> serviceOrderList = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMERS";
        try (Connection con = DatabaseAdapter.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                ServiceContractOrder SVO = new ServiceContractOrder();
                SVO.setDate(LocalDateTime.parse(rs.getString("Date"), formatter));


            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return serviceOrderList;
    } */
}
