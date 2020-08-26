package Databases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DBConnector
{
    static String table = "users";
    public void addUser(int id, String email, String nickname, String password) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + table + " VALUES (?, ?, ?, ?)");
        stmt.setInt(1, id);
        stmt.setString(2, email);
        stmt.setString(3, nickname);
        stmt.setString(4, password);
        stmt.execute();
    }

    public ArrayList<Integer> ListOfUsers(String nickname) throws SQLException
    {
        ArrayList<Integer> users = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement("SELECT USERID FROM " + table + " WHERE NICKNAME = ?");
        stmt.setString(1, nickname);
        ResultSet res = stmt.executeQuery();
        while(res.next())
            users.add(res.getInt(1));

        return users;
    }

}
