package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongDAO extends DBConnector implements DBManager
{
    static String table = "songs";
    @Override
    public void addRow(int SongId, String SongName, int ArtistId) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + table + " VALUES (?, ?, ?, ?)");
        stmt.setInt(1, SongId);
        stmt.setString(2, SongName);
        stmt.setInt(3, ArtistId);
        stmt.setInt(4, 0);
        stmt.execute();
    }

    @Override
    public ArrayList<Integer> ToList(String name)
    {
        return null;
    }
}
