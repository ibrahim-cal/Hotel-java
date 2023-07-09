
package beans;


public class Pays {
    
    private int P_Id;
    private String P_Nom;

     public Pays(int P_Id, String P_Nom) {
        this.P_Id = P_Id;
        this.P_Nom = P_Nom;
    }
    
    public Pays(int P_Id) {
        this.P_Id = P_Id;
    }

 
    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int P_Id) {
        this.P_Id = P_Id;
    }

    public String getP_Nom() {
        return P_Nom;
    }

    public void setP_Nom(String P_Nom) {
        this.P_Nom = P_Nom;
    }

    @Override
    public String toString() {
        return P_Nom; 
    }
    
}
