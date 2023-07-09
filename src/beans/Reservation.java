
package beans;

public class Reservation {

  
    
   private int Res_Id; 
   private Client resCli;
   private Chambre resCh;
   private Planning resPl;
   private int NbPers;

   

    public Reservation(int Res_Id,Client resCli, Chambre resCh, Planning resPl, int NbPers) {
        
        this.Res_Id = Res_Id;
        this.resCli = resCli;
        this.resCh = resCh;
        this.resPl = resPl;
        this.NbPers = NbPers;
    }

     public Reservation() {
    }
    
    public int getRes_Id() {
        return Res_Id;
    }

    public void setRes_Id(int Res_Id) {
        this.Res_Id = Res_Id;
    }


    public Client getResCli() {
        return resCli;
    }

    public void setResCli(Client resCli) {
        this.resCli = resCli;
    }

    public Chambre getResCh() {
        return resCh;
    }

    public void setResCh(Chambre resCh) {
        this.resCh = resCh;
    }

    public Planning getResPl() {
        return resPl;
    }

    public void setResPl(Planning resPl) {
        this.resPl = resPl;
    }

    public int getNbPers() {
        return NbPers;
    }

    public void setNbPers(int NbPers) {
        this.NbPers = NbPers;
    }

    
}