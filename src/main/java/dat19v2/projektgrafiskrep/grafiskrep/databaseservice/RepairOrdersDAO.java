package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RepairOrdersDAO {

    public void insert(Repair repair) {
        String sql1 = "INSERT INTO customers" + "(CVR, Name, Address, Phone, Email)" + "VALUES" +
                "(?,?,?,?,?)";
        String sql2 = "INSERT INTO repairorders" + "(date, customers_idcustomers, machines_idmachines)" +
                "VALUES (?, LAST_INSERT_ID(), idmachines FROM machines WHERE ModelNr = ?)";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement customerPs = con.prepareStatement(sql1);
             PreparedStatement repairOrderPs = con.prepareStatement(sql2))
        {

            customerPs.setString(1,repair.getCustomer().getCvr());
            customerPs.setString(2,repair.getCustomer().getName());
            customerPs.setString(3,repair.getCustomer().getAddress());
            customerPs.setString(4,repair.getCustomer().getPhoneNr());
            customerPs.setString(5,repair.getCustomer().getEmail());
            customerPs.executeUpdate();

            repairOrderPs.setString(1,repair.getDate().toString());
            repairOrderPs.setString(2,repair.getMachine().getModelNr());
            repairOrderPs.executeUpdate();

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }
}
