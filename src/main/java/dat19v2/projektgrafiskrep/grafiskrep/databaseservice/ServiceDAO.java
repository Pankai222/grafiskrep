package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class ServiceDAO implements IDAO{

    public static void insert(Service service) {
        String sql = "INSERT INTO services" + "(Date)" + "VALUES(?)";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,service.getDate().toString());

        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    public static void delete(){};
    public static void update(){};
    public static void selectAll(){};
}
