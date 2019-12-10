package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RepairDAO {

    public void insert(Repair repair) {
        String sql = "INSERT INTO repairs" + "(Price)" + "VALUES(?)";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(2, repair.getPrice());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void delete() {
    }

    public void selectAll() {

    }

    public void select() {


    }


}
