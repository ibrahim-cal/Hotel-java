
package daoMysql;

import beans.Chambre;
import dao.ChambDao;

import dao.DaoException;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.DaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ChambresDaoMysql implements ChambDao {
    
    private DaoFactory daoFactory;
    
    private static final String SQL_SELECT_TOUS = "Select Ch_Num, Ch_Bain, Ch_Douche, Ch_WC, Ch_Couchage from chambre order by Ch_Num";
   
    private static final String SQL_INSERT = "Insert into chambre(Ch_Bain, Ch_Douche, Ch_WC, Ch_Couchage) values (?,?,?,?,?)";
    
    private static final String SQL_DELETE = "Delete from chambre where Ch_Num = ?";
    
    private static final String SQL_UPDATE = "Update chambre set Ch_Bain = ?, Ch_Douche = ?, Ch_WC = ?, Ch_Couchage = ? where Ch_Num = ?";
    
    private static final String SQL_SELECT_NUMCHAMBRE = "Select Ch_Num from chambre order by Ch_Num";
    
    
    
       public ChambresDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
         
   
       @Override
    public ArrayList <Chambre> selectChambres() throws DaoException {
      
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Chambre> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next())
            {  
                myList.add(new Chambre(resu.getInt(1),resu.getBoolean(2),resu.getBoolean(3),
                        resu.getBoolean(4),resu.getInt(5)));
             }
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
  
        return myList;
      
    }

    @Override
    public void deleteChambres(int numch) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertChambres(Chambre cham) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateChambres(Chambre cham) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
