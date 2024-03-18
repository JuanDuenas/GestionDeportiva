package co.edu.uptc.control;


import co.edu.uptc.model.Affiliated;
import co.edu.uptc.persistence.Connection;
import org.bson.types.ObjectId;

public class AffiliatedService {
    private Connection c;

    public AffiliatedService(){
        c = new Connection();
    }
    public Affiliated insertAffiliated(Affiliated affiliated){
        return c.insert(affiliated);
    }

    public String getAffiliated(){
        return c.getAffiliated();
    }

    public Affiliated updateAffiliated(String dni, Affiliated affiliated){
        return c.update(dni,affiliated);
    }

    public boolean deleteAffiliated(String dni){
        return c.delete(dni);
    }

    public String getAffiliatedByDni(String dni){
        return c.getAffiliatedByDni(dni);
    }
}
