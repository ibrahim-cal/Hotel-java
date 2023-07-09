
package daoMysql;

import beans.Planning;

import dao.PlanningDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlanningDaoMysql implements PlanningDao {

    
     private DaoFactory daoFactory;
     
     private static final String SQL_SELECT_TOUS = "Select Pl_Id, Pl_Date from planning";
             
    
        public PlanningDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

              
              
    @Override
    public ArrayList selectPlanning() throws DaoException {
       
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList<Planning> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next())
            {  
                myList.add(new Planning(resu.getInt(1),resu.getDate(2)));
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
    
}
