/*
hotel
 */
package beans;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
   
    private int Cl_Id;
    private String Cl_Nom;
    private String Cl_Prenom;
    private String Cl_Adresse;
    private String Cl_CP;
    private String Cl_Ville;
    private Pays paysCli;
    private Date Cl_Naiss;

    public Client() {
    }

    public Client(String Cl_Nom) {
        this.Cl_Nom = Cl_Nom;
    }
    

    public Client(int Cl_Id, String Cl_Nom) {
        this.Cl_Id = Cl_Id;
        this.Cl_Nom = Cl_Nom;
    }
    
    public Client(int Cl_Id, String Cl_Nom, String Cl_Prenom, String Cl_Adresse, String Cl_CP, String Cl_Ville, Pays paysCli, Date Cl_Naiss) {
      
        this.Cl_Id = Cl_Id;
        this.Cl_Nom = Cl_Nom;
        this.Cl_Prenom = Cl_Prenom;
        this.Cl_Adresse = Cl_Adresse;
        this.Cl_CP = Cl_CP;
        this.Cl_Ville = Cl_Ville;
        this.paysCli = paysCli;
        this.Cl_Naiss = Cl_Naiss;
    }

    public int getCl_Id() {
        return Cl_Id;
    }

    public void setCl_Id(int Cl_Id) {
        this.Cl_Id = Cl_Id;
    }

    public String getCl_Nom() {
        return Cl_Nom;
    }

    public void setCl_Nom(String Cl_Nom) {
        this.Cl_Nom = Cl_Nom;
    }

    public String getCl_Prenom() {
        return Cl_Prenom;
    }

    public void setCl_Prenom(String Cl_Prenom) {
        this.Cl_Prenom = Cl_Prenom;
    }

    public String getCl_Adresse() {
        return Cl_Adresse;
    }

    public void setCl_Adresse(String Cl_Adresse) {
        this.Cl_Adresse = Cl_Adresse;
    }

    public String getCl_CP() {
        return Cl_CP;
    }

    public void setCl_CP(String Cl_CP) {
        this.Cl_CP = Cl_CP;
    }

    public String getCl_Ville() {
        return Cl_Ville;
    }

    public void setCl_Ville(String Cl_Ville) {
        this.Cl_Ville = Cl_Ville;
    }

    public Pays getPaysCli() {
        return paysCli;
    }

    public void setPaysCli(Pays paysCli) {
        this.paysCli = paysCli;
    }

    public Date getCl_Naiss() {
        return Cl_Naiss;
    }

    public void setCl_Naiss(Date Cl_Naiss) {
        this.Cl_Naiss = Cl_Naiss;
    }
    
    public String getCl_NaissBE() {
        String tmp;

        if (this.Cl_Naiss == null)
          tmp = "";
        else
          {
          SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
          tmp = dateParser.format(this.Cl_Naiss);
          }
        return tmp;
    }

    public void setCl_NaissBE(String dateApp) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.Cl_Naiss = dateParser.parse(dateApp);
        } catch (ParseException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return Cl_Nom;
    }
    
    
   
}
