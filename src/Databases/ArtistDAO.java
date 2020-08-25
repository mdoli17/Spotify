package Databases;

import java.sql.*;
import java.util.ArrayList;

public class ArtistDAO extends DBConnector implements  DBManager
{

    private String table = "";
    @Override
    public void addRow(int ArtistId, String ArtistName, int AlbumId) throws SQLException
    {

        PreparedStatement addStatement = connection.prepareStatement("INSERT INTO "+ table + " VALUES (?, ?, ?)");
        addStatement.setString(1, Integer.toString(ArtistId));
        addStatement.setString(2, ArtistName);
        addStatement.setString(3, Integer.toString(AlbumId));
        addStatement.execute();
    }

    @Override
    public ArrayList<Integer> ToList(String ArtistName) throws SQLException {
        ArrayList<Integer> Albums = new ArrayList<>();
        PreparedStatement stmt = connection.prepareStatement("SELECT ALBUMID FROM " +
                table + " WHERE ARTISTNAME = ?");
        stmt.setString(1, ArtistName);
        ResultSet res = stmt.executeQuery();
        while(res.next())
        {
            int next = res.getInt("ALBUMID");
            Albums.add(next);
        }
        return Albums;
    }

}
