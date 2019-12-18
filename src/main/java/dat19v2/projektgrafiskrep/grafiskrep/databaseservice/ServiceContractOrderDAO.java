package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.Service;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ServiceContractOrderDAO {

    public void insert(ServiceContractOrder SCO) {
        String sql1 = "INSERT INTO customers" + "(CVR, Name, Address, Phone, Email)" + "VALUES" +
                "(?,?,?,?,?)";
        String sql2 = "INSERT INTO serviceContractOrders(date, customers_idcustomers, machines_idmachines)" +
                "SELECT ?, (SELECT MAX(idcustomers) FROM customers), idmachines FROM machines WHERE ModelNr = ?";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement customerPs = con.prepareStatement(sql1);
             PreparedStatement serviceOrderPs = con.prepareStatement(sql2)) {

            customerPs.setString( 1, SCO.getCustomer().getCvr());
            customerPs.setString( 2, SCO.getCustomer().getName());
            customerPs.setString( 3, SCO.getCustomer().getAddress());
            customerPs.setString( 4, SCO.getCustomer().getPhoneNr());
            customerPs.setString(5, SCO.getCustomer().getEmail());
            customerPs.executeUpdate();

            for ( Service service : SCO.getServices() ) {
                serviceOrderPs.setString( 1, service.getDate().toString() );
                serviceOrderPs.setString(2, service.getMachine().getModelNr() );
                serviceOrderPs.executeUpdate();
            }

            serviceOrderPs.setString( 2, SCO.getDate().toString() );
            serviceOrderPs.executeUpdate();
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
