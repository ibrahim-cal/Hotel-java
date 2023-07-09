
package dao;

import beans.Reservation;
import java.util.ArrayList;
import java.util.Date;

public interface ReservationDao {
    
    void deleteReservation (int delRes) throws DaoException;
    
    void insertReservation (Reservation res) throws DaoException;
    
    ArrayList selectReservation() throws DaoException;
    
    ArrayList selectReservationParNom(String Nom) throws DaoException;
      
    ArrayList selectReservationParNumeroChambre (int Num) throws DaoException;
    
    ArrayList selectReservationParDate (Date date) throws DaoException;
    
    void updateReservation(Reservation res) throws DaoException;
    
}
