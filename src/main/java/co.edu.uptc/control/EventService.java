package co.edu.uptc.control;

import co.edu.uptc.model.Affiliated;
import co.edu.uptc.model.Event;
import co.edu.uptc.persistence.ConnectionEvent;
import org.bson.types.ObjectId;

public class EventService {
    private ConnectionEvent c;

    public EventService(){
        c = new ConnectionEvent();
    }

    public Event inserEvent(Event event){
        return c.insertEvent(event);
    }

    public String getEvent(){
        return c.getEvent();
    }

    public Event updateEvent(String dni, Event event){
        return c.updateEvent(dni,event);
    }

    public boolean deleteEvent(ObjectId id){
        return c.deleteEvent(id);
    }
}
