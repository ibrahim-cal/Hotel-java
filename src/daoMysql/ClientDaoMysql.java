
package daoMysql;

import beans.Client;
import beans.Pays;

import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClientDaoMysql implements ClientDao {
    
    private DaoFactory daoFactory;

     
    
    private static final String SQL_SELECT_TOUS = "Select Cl_Id, Cl_Nom, Cl_Prenom, Cl_Adresse, Cl_CP, Cl_Ville, Cl_Pays, P_Nom, Cl_Naiss from client ,pays  where Cl_Pays= P_Id order by 1";
           
    private static final String SQL_INSERT = "Insert into client (Cl_Id, Cl_Nom, Cl_Prenom, Cl_Adresse, Cl_CP, Cl_Ville, Cl_Pays, Cl_Naiss) values (?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE = "delete from client where Cl_Id = ?";
    
    private static final String SQL_UPDATE = "Update client set Cl_Nom = ?, Cl_Prenom = ? ," + 
            "Cl_Adresse = ?, Cl_CP = ?, Cl_Ville = ?, Cl_Pays = ?, Cl_Naiss = ? where Cl_Id = ?";
    
    private static final String SQL_CLI_BY_ID = "select * from client where Cl_Id = ?";


    public ClientDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    
    @Override
    public Client selectClientById(int id) throws DaoException {
      
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        Client cli = null ; 
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_CLI_BY_ID, false, id);
            resu = prepStat.executeQuery();
            
            Pays paysCli = new Pays (resu.getInt(7),resu.getString(8));
            cli = new Client(resu.getInt(1),  resu.getString(2), resu.getString(3),resu.getString(4), resu.getString(5), resu.getString(6), paysCli, resu.getDate(9));            
            
            
           
        }
        catch (SQLException e) {
            throw new DaoException(e);
        }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
  
        return cli;
    }        

    
    
    
    @Override
    public void deleteClient(int delCl) throws DaoException 
     {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, delCl);
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
    public void insertClient(Client cli) throws DaoException 
    {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false, 
                    cli.getCl_Id(),
                    cli.getCl_Nom(), cli.getCl_Prenom(), cli.getCl_Adresse(),
                    cli.getCl_CP(),cli.getCl_Ville(), cli.getPaysCli().getP_Id(),cli.getCl_Naiss());
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
    public ArrayList <Client> selectClient() throws DaoException {
      
        Connection conn=null;
        PreparedStatement prepStat=null;
        ResultSet resu=null;
        
        ArrayList <Client> myList = new ArrayList();
                     
        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[])null);
            resu = prepStat.executeQuery();
            while (resu.next())
            {  
                myList.add(new Client(resu.getInt(1),resu.getString(2),resu.getString(3),resu.getString(4),resu.getString(5),
                        resu.getString(6),
                        new Pays (resu.getInt(7),resu.getString(8)),resu.getDate(9)));
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
    public void updateClient(Client cli) throws DaoException {
        
         {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
        conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
               cli.getCl_Nom(), cli.getCl_Prenom(), cli.getCl_Adresse(),
               cli.getCl_CP(),cli.getCl_Ville(), cli.getPaysCli().getP_Id(),cli.getCl_Naiss(),
                cli.getCl_Id());
            prepStat.executeUpdate();
            } 
        catch (SQLException e) {
            throw new DaoException(e);
                                 }
        finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
                 }
        }
        
        
    }
    }


  
    

