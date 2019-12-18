package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseAdapter implements IDAO{

    private static Connection con;

    // defining settings for connection to GrafiskRepDB
    final static String username = "root";
    final static String password = "rootkode";
    //database-url including changing of timezone t/-=-o UTC
    final static String url = "jdbc:mysql://localhost:3306/GrafiskRep?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DatabaseAdapter(){}

    public static Connection getConnection() throws Exception {
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database. User = " + username);
        return con;
    }
}
