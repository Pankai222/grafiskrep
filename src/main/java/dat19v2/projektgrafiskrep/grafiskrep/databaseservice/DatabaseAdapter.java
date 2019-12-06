package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseAdapter {

    private static Connection con;

    // defining settings for connection to GrafiskRepDB
    String username = "root";
    String password = "rootkode";
    //database-url including changing of timezone to UTC
    String url = "jdbc:mysql://localhost:3306/GrafiskRep?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    // for initializing databaseAdapter with connection
    public DatabaseAdapter(){
        try {
            System.out.println("Connected to GrafiskRepDB");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
