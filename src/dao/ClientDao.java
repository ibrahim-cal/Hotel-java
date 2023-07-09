
package dao;

import beans.Client;
import java.util.ArrayList;

public interface ClientDao {
    
    ArrayList selectClient() throws DaoException;
    
    Client selectClientById(int id) throws DaoException;
    
    void insertClient (Client cli) throws DaoException;
    
    void deleteClient (int delCl) throws DaoException;
    
    void updateClient(Client cli) throws DaoException;
    
}
