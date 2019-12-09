package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.pos.RepairType;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RepairTypeDAO {
    // NOTE: I would strongly advise for using more specific exceptions
    // than the general one
    // HERE IS WHY:
    // * We dont know what we are handling, anything could have caused it
    // * common practice is the let the exception "bubble up" if we cant
    // handle it here
    // * be able to give a better reason for why it crashed

    // inserts repair types into the database
    public void insert(RepairType repairType ) {
        String sql = "INSERT INTO repairTypes" + "(Name, Price)" + "VALUES (?, ?)";
        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement( sql ) )
        {
            ps.setString( 1, repairType.getName() );
            ps.setInt( 2, repairType.getPrice() );
            ps.executeUpdate();
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    public void delete() {

    }

    public void update() {

    }

    public void select() {
    }
}
