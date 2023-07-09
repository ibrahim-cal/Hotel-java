
package beans;

public class Chambre {
    
    private Integer Ch_Num;
    private Boolean Ch_Bain;
    private Boolean Ch_Douche;
    private Boolean Ch_WC;
    private Integer Ch_Couchage;
    private String test; // variable utiliée pour etre remplacee par l'étoile dans la combo de reservation

    public Chambre(Integer Ch_Num,String test) {   // contructeur utilisé seulement pour satisfaire la méthode d'affichage dans comboBox
        this.Ch_Num = Ch_Num;
        this.test = test;
    }

    public Chambre(int Ch_Num) {
        this.Ch_Num = Ch_Num;
    }

    
    public Chambre() {
    }
    
    public Chambre(int Ch_Num, Boolean Ch_Bain, Boolean Ch_Douche, Boolean Ch_WC, int Ch_Couchage) {
        this.Ch_Num = Ch_Num;
        this.Ch_Bain = Ch_Bain;
        this.Ch_Douche = Ch_Douche;
        this.Ch_WC = Ch_WC;
        this.Ch_Couchage = Ch_Couchage;
    }

    public int getCh_Num() {
        return Ch_Num;
    }

    public void setCh_Num(int Ch_Num) {
        this.Ch_Num = Ch_Num;
    }

    public Boolean getCh_Bain() {
        return Ch_Bain;
    }

    public void setCh_Bain(Boolean Ch_Bain) {
        this.Ch_Bain = Ch_Bain;
    }

    public Boolean getCh_Douche() {
        return Ch_Douche;
    }

    public void setCh_Douche(Boolean Ch_Douche) {
        this.Ch_Douche = Ch_Douche;
    }

    public Boolean getCh_WC() {
        return Ch_WC;
    }

    public void setCh_WC(Boolean Ch_WC) {
        this.Ch_WC = Ch_WC;
    }

    public int getCh_Couchage() {
        return Ch_Couchage;
    }


    public void setCh_Couchage(int Ch_Couchage) {
        this.Ch_Couchage = Ch_Couchage;
    }

    @Override
    public String toString() {
        
        if(this.Ch_Num == -1) return "*" ;
        
        return Integer.toString(this.Ch_Num); 
    }
 
    
    
}