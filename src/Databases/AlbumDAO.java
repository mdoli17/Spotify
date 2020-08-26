package Databases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDAO extends DBConnector implements DBManager
{
    static String table = "albums";
    @Override
    public void addRow(int AlbumId, String AlbumName, int SongId) throws SQLException
    {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + table + " VALUES (?, ?, ?)");
        stmt.setInt(1, AlbumId);
        stmt.setString(2, AlbumName);
        stmt.setInt(3, SongId);
        stmt.execute();
    }

    @Override
    public ArrayList<Integer> ToList(String AlbumName) throws SQLException {
        ArrayList<Integer> songs = new ArrayList<>();
        PreparedStatement stmt = connection.prepareStatement("SELECT SONGID FROM " + table + " WHERE ALBUMNAME = ?");
        stmt.setString(1,AlbumName);
        ResultSet res = stmt.executeQuery();
        while(res.next())
            songs.add(res.getInt("SONGID"));
        return songs;
    }
}
