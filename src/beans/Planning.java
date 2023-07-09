
package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Planning {
    
    private int Pl_Id;
    private Date Pl_Date;

    public Planning() {
    }

    public Planning(int Pl_Id, Date Pl_Date) {
        this.Pl_Id = Pl_Id;
        this.Pl_Date = Pl_Date;
    }

    public int getPl_Id() {
        return Pl_Id;
    }

    public void setPl_Id(int Pl_Id) {
        this.Pl_Id = Pl_Id;
    }

    public Date getPl_Date() {
        return Pl_Date;
    }

    public void setPl_Date(Date Pl_Date) {
        this.Pl_Date = Pl_Date;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yyyy").format(Pl_Date);
    }
    
    
}
