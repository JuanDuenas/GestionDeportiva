package co.edu.uptc.GestionDeportiva.repo;

import co.edu.uptc.GestionDeportiva.model.AffiliatedManagment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AffiliatedRepo extends MongoRepository<AffiliatedManagment,String> {
}
