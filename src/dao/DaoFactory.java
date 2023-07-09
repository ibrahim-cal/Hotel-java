
package dao;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
  
    private static final String FICHIER_PROPERTIES       = "dao/config.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    private static final String PROPERTY_CLI_DAO         = "clientdao";
    private static final String PROPERTY_RES_DAO         = "reservationdao";
    private static final String PROPERTY_CH_DAO          = "chambresdao";
    private static final String PROPERTY_PL_DAO          = "planningdao";
    private static final String PROPERTY_PAYS_DAO        = "paysdao";
    
    private String              url;
    private String              driver;
    private String              username;
    private String              password;
    private String              cliDao;
    private String              resDao;
    private String              chDao;
    private String              plDao;
    private String              paysDao;

    
    /* Pattern Singleton */
    private static DaoFactory uniqueInstance = new DaoFactory();
    public static DaoFactory getInstance()
    {
        
        return uniqueInstance;
    }
    
    private DaoFactory() throws DaoConfigurationException
    {
        Properties properties = new Properties();
            
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if (fichierProperties == null) {
            throw new DaoConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }
        
        try {
            properties.load( fichierProperties );
           
            url =      properties.getProperty (PROPERTY_URL );
            driver =   properties.getProperty (PROPERTY_DRIVER );
            username = properties.getProperty (PROPERTY_NOM_UTILISATEUR );
            password = properties.getProperty (PROPERTY_MOT_DE_PASSE );
            cliDao =   properties.getProperty (PROPERTY_CLI_DAO);
            resDao =   properties.getProperty (PROPERTY_RES_DAO);
            chDao =    properties.getProperty (PROPERTY_CH_DAO);
            plDao =    properties.getProperty (PROPERTY_PL_DAO);
            paysDao =  properties.getProperty (PROPERTY_PAYS_DAO);
            
        } catch (IOException e) {
            throw new DaoConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        try {
            Class.forName(driver);
            }
        catch (ClassNotFoundException e)
            {
            throw new DaoConfigurationException("Le driver est introuvable", e);
            }
    }

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username,password);
    }
    
   
    public ClientDao getDAOClient()
    {
        try {
        Class cliDaoClass = Class.forName(cliDao);
        Constructor[] constr = cliDaoClass.getConstructors();
        return (ClientDao)constr[0].newInstance(this);
            }
        catch (Exception e)
        {
            throw new DaoConfigurationException ("Probleme d'injection avec la classe client", e);
        }
        
        }
    
    
    public ReservationDao getDAOReservation()
    {
        try {
        Class resDaoClass = Class.forName(resDao);
        Constructor[] constr = resDaoClass.getConstructors();
        return (ReservationDao)constr[0].newInstance(this);
            }
        catch (Exception e)
        {
            throw new DaoConfigurationException ("Probleme d'injection avec la classe reservation", e);
        }
        
        }
    
        
    public ChambDao getDAOChamb()
    {
        try {
        Class chDaoClass = Class.forName(chDao);
        Constructor[] constr = chDaoClass.getConstructors();
        return (ChambDao)constr[0].newInstance(this);
            }
        catch (Exception e)
        {
            throw new DaoConfigurationException ("Probleme d'injection avec la classe chambre", e);
        }
        
        }
          
          
      public PlanningDao getDAOPlanning()
    {
        try {
        Class plDaoClass = Class.forName(plDao);
        Constructor[] constr = plDaoClass.getConstructors();
        return (PlanningDao)constr[0].newInstance(this);
            }
        catch (Exception e)
        {
            throw new DaoConfigurationException ("Probleme d'injection avec la classe planning", e);
        }
        
        }
              
    public PaysDao getDAOPays()
    {
        try {
        Class paysDaoClass = Class.forName(paysDao);
        Constructor[] constr = paysDaoClass.getConstructors();
        return (PaysDao)constr[0].newInstance(this);
            }
        catch (Exception e)
        {
            throw new DaoConfigurationException ("Probleme d'injection avec la classe pays", e);
        }
        
        }
    
}
