package presentation;

import beans.Client;
import beans.Pays;
import java.util.*; // pour ArrayList

public class TableModelClient extends javax.swing.table.AbstractTableModel {
    
    private String[] columnNames = {"Id client", "Nom", "Prenom", "Adresse", "CP", "Ville", "Pays", "Date Naiss"};
    private ArrayList <Client> myList;

    public TableModelClient (ArrayList myList)
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
        Client myCli = myList.get(row);
        switch (col)
        {
            case 0 :    return myCli.getCl_Id();
            case 1 :    return myCli.getCl_Nom();
            case 2 :    return myCli.getCl_Prenom();
            case 3 :    return myCli.getCl_Adresse();
            case 4 :    return myCli.getCl_CP();
            case 5 :    return myCli.getCl_Ville();
            case 6 :    return myCli.getPaysCli().getP_Nom();
            case 7 :    return myCli.getCl_NaissBE();
        }
        return null;
    }

    @Override
    public Class getColumnClass(int c) {

        switch (c)
        {
            case 0 :    return int.class;
            case 1 :    return String.class;
            case 2 :    return String.class;
            case 3 :    return String.class;
            case 4 :    return String.class;
            case 5 :    return String.class;
            case 6 :    return String.class;
            case 7 :    return String.class;
        }
        return null;
    }
    
        public void setMyList (ArrayList myList)
    {
        this.myList = myList;
        this.fireTableDataChanged();
    }
    
    public ArrayList <Client> getMyList ()
    {
        return myList;
    }
    
    public Client getMyList (int index)
    {
        return myList.get(index);
    }
    
    
    
}

