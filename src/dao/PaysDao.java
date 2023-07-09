
package dao;

import beans.Pays;
import java.util.ArrayList;


public interface PaysDao {
    
     ArrayList <Pays> selectPays() throws DaoException;
    
}
