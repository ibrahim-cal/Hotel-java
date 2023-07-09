
package daoMysql;

import beans.Chambre;
import dao.ChambDao;
import beans.Client;
import beans.Pays;
import beans.Planning;
import beans.Reservation;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.ReservationDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class ReservationDaoMysql implements ReservationDao{

    private DaoFactory daoFactory;                         
    
    private static final String SQL_SELECT_TOUS = "Select Res_Id, R.Cl_Id,Cl_Nom," + 
              "R.Ch_Num, R.Pl_Id, Pl_Date, NbPers from reservation R, client C, chambre CH,"+
            "planning P where R.Cl_Id = C.Cl_Id and R.Ch_Num = CH.Ch_Num and R.Pl_Id = P.Pl_Id";
       
    
    private static final String SQL_SELECT_RESERVATION_PAR_NOM  = "Select Res_Id, R.Cl_Id,Cl_Nom," + 
              "R.Ch_Num, Pl_Date, NbPers from reservation R, client, planning "
            + " where Cl_Nom LIKE = '_%'";
               
    
    private static final String SQL_SELECT_RESERVATION_PAR_NUM  = "Select Res_Id, R.Cl_Id,Cl_Nom," + 
              "R.Ch_Num, R.Pl_Id, Pl_Date, NbPers from reservation R, client C, chambre CH,"+ 
            "planning P where R.Cl_Id = C.Cl_Id and R.Ch_Num = CH.Ch_Num and R.Pl_Id = P.Pl_Id AND R.Ch_Num = ?";
    
    private static final String SQL_SELECT_RESERVATION_PAR_DATE  = "Select Res_Id, R.Cl_Id,Cl_Nom," +      // TROUVER REQUETE POUR TRIER SUR INTERVALLE DATE **********************
              "R.Ch_Num, R.Pl_Id, Pl_Date, NbPers from reservation R, client , chambre , planning "
              + " where R.Cl_Id = C.Cl_Id and R.Ch_Num = Ch.CH_Num and R.Pl_Id = P.Pl_Id AND ";
    
    private static final String SQL_INSERT =  "Insert into reservation (Cl_Id, Ch_Num, Pl_Id, NbPers) values (?, ?, ?, ?)";
    
    private static final String SQL_DELETE = "delete from reservation where Res_Id = ?";
    
    private static final String SQL_UPDATE = "Update reservation set  Cl_Id = ?, Ch_Num = ?, Pl_Id = ? ," + 
            "NbPers = ? where Res_Id = ?";

    public ReservationDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    
    @Override
    public void deleteReservation(int delRes) throws DaoException 
              {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, delRes);
            prepStat.executeUpdate();
        } 
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }
    
    

   
    
    @Override
    public void insertReservation(Reservation res) throws DaoException {
        
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false,
                   
                   res.getResCli().getCl_Id(), res.getResCh().getCh_Num(), res.getResPl().getPl_Id(),
                   res.getNbPers());
            prepStat.executeUpdate();
        } 
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    
    
    @Override
    public ArrayList <Reservation> selectReservation() throws DaoException {
       
         Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList<Reservation> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next())
            {  
                myList.add
                (new Reservation(
                        resu.getInt(1), 
                        new Client (resu.getInt(2),resu.getString(3)),
                        new Chambre (resu.getInt(4)),
                        new Planning (resu.getInt(5), resu.getDate(6)),
                        resu.getInt(7)));
                        
                        
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
    public ArrayList <Reservation> selectReservationParNom(String Nom) throws DaoException {
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Reservation> myList = new ArrayList();
        
        try {
            conn = daoFactory.getConnection();
         
            prepStat = DaoUtil.initialisationRequetePreparee(conn,  SQL_SELECT_RESERVATION_PAR_NOM , false, Nom);
            
            resu = prepStat.executeQuery();
            while (resu.next())
            {                
              
                myList.add
                        (new Reservation(
                        resu.getInt(1),
                        new Client (resu.getInt(2),resu.getString(3)),
                        new Chambre (resu.getInt(4)),
                        new Planning (resu.getInt(5), resu.getDate(6)),
                        resu.getInt(7)));
                         
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
    public ArrayList <Reservation> selectReservationParNumeroChambre(int Num) throws DaoException {
      
           Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList myList = new ArrayList();
        
        try {
            conn = daoFactory.getConnection();
            if (Num == -1)
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            else
                prepStat = DaoUtil.initialisationRequetePreparee(conn,  SQL_SELECT_RESERVATION_PAR_NUM , false, Num);
            
            resu = prepStat.executeQuery();
            while (resu.next())
            {                
              
                myList.add
                       (new Reservation(
                        resu.getInt(1),
                        new Client (resu.getInt(2),resu.getString(3)),
                        new Chambre (resu.getInt(4)),
                        new Planning (resu.getInt(5), resu.getDate(6)),
                        resu.getInt(7)));
                
          
                
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
    public ArrayList <Reservation> selectReservationParDate(Date date) throws DaoException {   
        // A TERMINER ******************************************
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public void updateReservation(Reservation res) throws DaoException {
         {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
        /* RÃ©cupÃ©ration d'une connexion depuis la Factory */
        conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
                  res.getResCli().getCl_Id(), res.getResCh().getCh_Num(), 
                  res.getResPl().getPl_Id(), res.getNbPers(),
                  res.getRes_Id());
            prepStat.executeUpdate();
        } 
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
         
    }
        
        
    }}

  

    