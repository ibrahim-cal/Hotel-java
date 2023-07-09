
package dao;
import beans.Chambre;

import java.util.ArrayList;


public interface ChambDao {
    
 
    ArrayList <Chambre> selectChambres() throws DaoException;
    
    void deleteChambres(int numch) throws DaoException;
        
    int insertChambres(Chambre ch) throws DaoException;

    void updateChambres(Chambre ch) throws DaoException;
    
}
