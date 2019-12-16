package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.RepairType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepairTypeDAO {

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

//Returns an arraylist of all the repairtypes in the database.
    public ArrayList<RepairType> selectAll() {
        ArrayList<RepairType> repairTypes = new ArrayList<>();
        String sql = "SELECT * FROM repairtypes";

        try ( Connection con = DatabaseAdapter.getConnection();
              PreparedStatement ps  = con.prepareStatement( sql );
              ResultSet rs = ps.executeQuery() )
        {
            while ( rs.next() ) {
                RepairType repairType = new RepairType();
                repairType.setName( rs.getString( "name" ) );
                repairType.setPrice( rs.getInt( "Price" ) );

                repairTypes.add( repairType );
            }
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }

        return repairTypes;
    }
}
