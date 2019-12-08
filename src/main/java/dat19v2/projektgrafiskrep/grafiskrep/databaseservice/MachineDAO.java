package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MachineDAO {

    public void insert(Machine machine) {
        String sql = "INSERT INTO machines" + "(Type, Brand, ModelNr, Description, SerialNr)" +
                "VALUES (?,?,?,?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, machine.getType());
            ps.setString(2, machine.getBrand());
            ps.setString(3, machine.getModelNr());
            ps.setString(4, machine.getDesc());
            ps.setString(5, machine.getSerialNr());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
