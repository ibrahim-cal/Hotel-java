package presentation;

import beans.Reservation;
import java.util.*; // pour ArrayList

public class TableModelReservation extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Id res","Id client", "nom client", "num chambre","date reservation","nb personnes"};
    private ArrayList <Reservation> myList;

    public TableModelReservation (ArrayList myList)
    {
        this.myList = myList;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return myList.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Reservation myRes = myList.get(row);
        switch (col)
        {
            case 0 :    return myRes.getRes_Id();
            case 1 :    return myRes.getResCli().getCl_Id();
            case 2 :    return myRes.getResCli().getCl_Nom();
            case 3 :    return myRes.getResCh().getCh_Num();
            case 4:    return myRes.getResPl().getPl_Date();
            case 5 :    return myRes.getNbPers();
       
        }
        return null;
    }

    @Override
    public Class getColumnClass(int c) {
       
        switch (c)
        {
            case 0 :    return int.class;
            case 1 :    return int.class;
            case 2 :    return String.class;
            case 3 :    return int.class;
            case 4 :    return Date.class;
            case 5 :    return int.class;
       
        }
        return null;
    }
    
      public void setMyList (ArrayList myList)
    {
        this.myList = myList;
        this.fireTableDataChanged();
    }
    
    public ArrayList <Reservation> getMyList ()
    {
        return myList;
    }
    
    public Reservation getMyList (int index)
    {
        return myList.get(index);
    }
    
    
}