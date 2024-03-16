package co.edu.uptc.GestionDeportiva.service;

import co.edu.uptc.GestionDeportiva.model.AffiliatedManagment;
import co.edu.uptc.GestionDeportiva.repo.AffiliatedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AffiliatedService {

    public List<AffiliatedManagment> getAffiliateds();

    public AffiliatedManagment addAffiliated(AffiliatedManagment affiliated);

    public AffiliatedManagment deleteAffiliated(String id);

    public AffiliatedManagment updateAffiliated(String id, AffiliatedManagment affiliatedManagment);

}
