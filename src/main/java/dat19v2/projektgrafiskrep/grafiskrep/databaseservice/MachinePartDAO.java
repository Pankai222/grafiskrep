package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public abstract class MachinePartDAO {

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

    public ArrayList<MachinePart> selectAll() {
        ArrayList<MachinePart> partList = new ArrayList<>();
        String sql = "SELECT * FROM machineParts";

        try (Connection con = DatabaseAdapter.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MachinePart mp = new MachinePart();
                mp.setBrand(rs.getString("Brand"));
                mp.setName(rs.getString("Name"));
                mp.setPrice(rs.getInt("Price"));
                mp.setPartNr(rs.getString("PartNr"));
                mp.setDesc(rs.getString("Description"));
                partList.add(mp);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return partList;
    }
}
