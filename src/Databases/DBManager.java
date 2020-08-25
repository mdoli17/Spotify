package Databases;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DBManager
{
    void addRow(int id, String name, int otherId) throws SQLException;
    ArrayList<Integer> ToList(String name) throws SQLException;
}
