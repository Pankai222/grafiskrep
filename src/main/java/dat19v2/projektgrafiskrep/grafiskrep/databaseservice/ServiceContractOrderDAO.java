package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.Service;
import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContractOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ServiceContractOrderDAO implements IDAO{

    public static void insert(ServiceContractOrder SCO) {
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
    public static void delete(){};
    public static void update(){};
    public static void selectAll(){};
}
