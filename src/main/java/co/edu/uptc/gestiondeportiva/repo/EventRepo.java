package co.edu.uptc.GestionDeportiva.repo;

import co.edu.uptc.GestionDeportiva.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepo extends MongoRepository<Event,String> {
}
