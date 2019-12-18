package dat19v2.projektgrafiskrep.grafiskrep.databaseservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class DatabaseAdapter {

    private static Connection con;

    // defining settings for connection to GrafiskRepDB
    static final String username = "root";
    static final String password = "rootkode";
    //database-url including changing of timezone t/-=-o UTC
    static final String url = "jdbc:mysql://localhost:3306/GrafiskRep?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DatabaseAdapter(){}

    public static Connection getConnection() throws Exception {
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database. User = " + username);
        return con;
    }
}
