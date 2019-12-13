package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import dat19v2.projektgrafiskrep.grafiskrep.model.Customer;
import dat19v2.projektgrafiskrep.grafiskrep.model.pos.Sale;
import dat19v2.projektgrafiskrep.grafiskrep.model.MachinePart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SaleDAO {


    public void insert(Sale sale) {
        String sql1 = "INSERT INTO customers" + "(CVR, Name, Address, Phone, Email)" + "VALUES" +
                "(?,?,?,?,?)";
        String sql2 = "INSERT INTO sales" + "(Date, TotalPrice, customers_idcustomers)" +
                "VALUES (?,?, LAST_INSERT_ID())";
        String sql3 = "INSERT INTO sales_has_machineParts" + "(sales_idsales, " +
                "machineParts_idmachineParts)" + "SELECT LAST_INSERT_ID(), idmachineParts FROM " +
                "machineParts" + " WHERE PartNr = ?";
        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement customerPs = con.prepareStatement(sql1);
             PreparedStatement salePs = con.prepareStatement(sql2);
             PreparedStatement bridgeTablePs = con.prepareStatement(sql3))
        {

            customerPs.setString(1,sale.getCustomer().getCvr());
            customerPs.setString(2,sale.getCustomer().getName());
            customerPs.setString(3,sale.getCustomer().getAddress());
            customerPs.setString(4,sale.getCustomer().getPhoneNr());
            customerPs.setString(5,sale.getCustomer().getEmail());
            customerPs.executeUpdate();

            salePs.setString(1,sale.getDate().toString());
            salePs.setInt(2,sale.getTotalPrice());
            salePs.executeUpdate();


            ArrayList<MachinePart> mp = new ArrayList<>();
            mp.add(new MachinePart("A0028180"));
            mp.add(new MachinePart("A0028181"));
            mp.add(new MachinePart("A0066319"));

            for (MachinePart s : mp) {
                bridgeTablePs.setString(1, s.getPartNr());
                bridgeTablePs.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("Err0r: " + e);
        }
    }
}
