package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;


import dat19v2.projektgrafiskrep.grafiskrep.model.GrafiskRep;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GrafikRepDAO {

    public void insert(GrafiskRep grafiskRep) {
        String sql = "INSERT INTO grafiskRep" + "(CVR, Address, PhoneNr, Email)" + "VALUES " +
                "(?," +
                "?,?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setString(1, grafiskRep.getCvr());
            ps.setString(2, grafiskRep.getAddress());
            ps.setString(3, grafiskRep.getPhoneNr());
            ps.setString(4, grafiskRep.getEmail());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
