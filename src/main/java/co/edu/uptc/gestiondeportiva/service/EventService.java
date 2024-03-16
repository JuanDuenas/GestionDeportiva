package co.edu.uptc.GestionDeportiva.service;

import co.edu.uptc.GestionDeportiva.model.AffiliatedManagment;
import co.edu.uptc.GestionDeportiva.model.Event;

import java.util.List;

public interface EventService {
    public List<Event> getEvents();

    public Event addEvent(Event event);

    public Event deleteEvent(String name);

    public Event updateEvent(String name, Event event);

}
