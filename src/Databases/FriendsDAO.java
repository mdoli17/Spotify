package Databases;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendsDAO extends DBConnector
{
    static String table = "friends";

    // Sets status between two users in row to 1
    public void DeclareFriendShip(int user1Id, int user2Id) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("SELECT FROM " + table + " WHERE USER1 = ? AND USER2 = ?");
        stmt.setInt(1, user1Id);
        stmt.setInt(2, user2Id);
        ResultSet res = stmt.executeQuery();
        if(res.next())
        {
            // set status
        }
    }

    // Adds a row in database where status is set to 0
    public void SendFriendRequest(int senderId, int receiverId) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + table + " VALUES (?, ?, ?)");
        stmt.setInt(1, senderId);
        stmt.setInt(2, receiverId);
        stmt.setInt(3, 0);
    }

    // Sets status between two users in row to -1
    public void DeclineFriendShip(int receiverId,  int senderId)
    {

    }

    // Removes row of two users from database
    public void CancelFriendShip(int user1Id, int user2Id) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM " + table + " WHERE (USER1 = ? AND USER2 = ?) OR (USER1 = ? AND USER2 = ?)");
        stmt.setInt(1, user1Id);
        stmt.setInt(2, user2Id);
        stmt.setInt(3, user2Id);
        stmt.setInt(4, user1Id);
        stmt.execute();
    }

    public boolean isFriend(int user1Id, int user2Id) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("SELECT STATUS FROM " + table + " WHERE (USER1 = ? AND USER2 = ?) OR (USER1 = ? AND USER2 = ?)");
        stmt.setInt(1, user1Id);
        stmt.setInt(2, user2Id);
        stmt.setInt(3, user2Id);
        stmt.setInt(4, user1Id);
        ResultSet res = stmt.executeQuery();
        if(res.next())
            return  res.getInt("STATUS") == 1;
        return false;
    }
}
