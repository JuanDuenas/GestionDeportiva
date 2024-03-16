package co.edu.uptc.control;


import co.edu.uptc.model.Affiliated;
import co.edu.uptc.persistence.Connection;

public class AffiliatedService {
    public Affiliated insertAffiliated(Affiliated affiliated){
        Connection c = new Connection();
        return c.insert(affiliated);
    }
}
