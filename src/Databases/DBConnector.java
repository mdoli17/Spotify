package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
    private static String username;
    private static String password;
    private static String server = "jdbc:mysql://localhost";
    private static String database;

    private static Connection connection;
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(server,username,password);
    }

    public static Connection getConnection()
    {
        return connection;
    }


}
