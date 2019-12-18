package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.service.ServiceContract;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class ServiceContractDAO {

//    Inserts a servicecontract object into the database.
    public void insert(ServiceContract serviceContract) {
        String sql = "INSERT INTO serviceContracts" + "(StartDate, EndDate)" + "VALUES(?,?)";
        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, serviceContract.getStartDate().toString());
            ps.setString(2, serviceContract.getEndDate().toString());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);

        }

    }
}
