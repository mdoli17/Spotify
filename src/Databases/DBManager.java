package Databases;

import java.util.ArrayList;

public interface DBManager
{
    void addRow(int id, String name, int otherId);
    ArrayList<Integer> ToList();
}
