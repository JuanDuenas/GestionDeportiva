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

    public void getAffiliated(){
        c.getAffiliated();
    }

    public Affiliated updateAffiliated(ObjectId id, Affiliated affiliated){
        return c.update(id,affiliated);
    }

    public boolean deleteAffiliated(ObjectId id){
        return c.delete(id);
    }
}
