package co.edu.uptc.GestionDeportiva.service.impl;

import co.edu.uptc.GestionDeportiva.model.AffiliatedManagment;
import co.edu.uptc.GestionDeportiva.repo.AffiliatedRepo;
import co.edu.uptc.GestionDeportiva.service.AffiliatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffiliatedServiceImpl implements AffiliatedService {
    @Autowired
    private AffiliatedRepo affiliatedRepo;


    public List<AffiliatedManagment> getAffiliateds(){
        return affiliatedRepo.findAll();
    }

    public AffiliatedManagment addAffiliated(AffiliatedManagment affiliated){
        return affiliatedRepo.save(affiliated);
    }

    public AffiliatedManagment deleteAffiliated(String id){
        AffiliatedManagment affiliatedManagment = affiliatedRepo.findById(id).get();
        affiliatedRepo.delete(affiliatedManagment);
        return affiliatedManagment;
    }

    public AffiliatedManagment updateAffiliated(String id, AffiliatedManagment affiliatedManagment){
        AffiliatedManagment affiliated = affiliatedRepo.findById(id).get();
        affiliated.setName(affiliatedManagment.getName());
        affiliated.setLastName(affiliatedManagment.getLastName());
        affiliated.setDni(affiliatedManagment.getDni());
        affiliated.setAge(affiliatedManagment.getAge());
        affiliatedRepo.save(affiliated);
        return affiliated;
    }

}
