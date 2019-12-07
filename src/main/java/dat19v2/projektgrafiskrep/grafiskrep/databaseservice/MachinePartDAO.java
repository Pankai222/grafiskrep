package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MachinePartDAO {

    public void insert(MachinePart machinePart) {
        String sql = "INSERT INTO machineParts" + "(Brand, Name, Price, PartNr, Description)" +
                "VALUES(?,?,?,?,?)";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, machinePart.getBrand());
            ps.setString(2, machinePart.getName());
            ps.setInt(3, machinePart.getPrice());
            ps.setString(4, machinePart.getPartNr());
            ps.setString(5, machinePart.getDesc());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
