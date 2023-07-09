/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import beans.Pays;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.PaysDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PaysDaoMysql implements PaysDao {
    
       private DaoFactory daoFactory;
       
       private static final String SQL_SELECT_TOUS = "Select * from pays";

   
       public PaysDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

  
       @Override
    public ArrayList<Pays> selectPays() throws DaoException {

         Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Pays> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next())
            {  
                myList.add(new Pays(resu.getInt(1),resu.getString(2)));
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
   

