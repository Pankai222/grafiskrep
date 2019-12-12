package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Machine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void delete( String modelNr ) {
        String sql = "DELETE FROM machines WHERE ModelNr = ?";
        try ( Connection con = DatabaseAdapter.getConnection();
              PreparedStatement ps = con.prepareStatement( sql ) )
        {
            ps.setString( 1, modelNr );
            ps.executeUpdate();
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    // NOTE: when inputting method argument, spell as is in the DB
    public void update( String whatToUpdate, String updateValue, String modelNr ) {
        String sql = "UPDATE machines" + "SET " + "?" + " = ?" + " WHERE ModelNr = ?";
        try ( Connection con = DatabaseAdapter.getConnection();
              PreparedStatement ps = con.prepareStatement( sql ) )
        {
            ps.setString( 1, whatToUpdate );
            ps.setString( 2, updateValue );
            ps.setString( 3, modelNr );
            ps.executeUpdate();
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    public void select( String modelNr ) {
        String sql = "SELECT * FROM machines WHERE ModelNr = ?";
        try ( Connection con = DatabaseAdapter.getConnection();
              PreparedStatement ps = con.prepareStatement( sql ) )
        {
            ps.setString( 1, modelNr );
            ps.executeQuery();
            /*
            while ( rs.next() ) {
                String type = rs.getString( "Type" );
                String brand = rs.getString( "Brand" );
                String modelnr = rs.getString( "ModelNr" );
                String desc = rs.getString( "Description" );
                System.out.format( "%s, %s, %s, %s, %s\n", type, brand, modelnr, desc, serialNr );
            }
            */
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }
    }

    public ArrayList<Machine> selectAll() {
        ArrayList<Machine> machines = new ArrayList<>();
        String sql = "SELECT * FROM machines";

        try ( Connection con = DatabaseAdapter.getConnection();
              PreparedStatement ps  = con.prepareStatement( sql );
              ResultSet rs = ps.executeQuery() )
        {
            while ( rs.next() ) {
                Machine machine = new Machine();
                machine.setType( rs.getString( "Type" ) );
                machine.setBrand( rs.getString( "Brand" ) );
                machine.setModelNr( rs.getString( "ModelNr" ) );
                machine.setDesc( rs.getString( "Description" ) );
                machines.add( machine );
            }
        } catch ( Exception ex ) {
            System.err.println( "ERROR: " + ex );
        }

        return machines;
    }
}
