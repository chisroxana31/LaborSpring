package Service;

import Domain.Events;
import Repo.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;


    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }


    public Events getEventById(Long eventId) {
        return eventsRepository.findById(eventId).orElse(null);
    }


    public void addEvent(Events event) {
        eventsRepository.save(event);
    }


    public List<Events> getEventsByName(String name) {
        return eventsRepository.findByName(name);
    }


    public void deleteEvent(Long eventId) {
        eventsRepository.deleteById(eventId);
    }


    public Events updateEvent(Long eventId, Events updatedEvent) {
        return eventsRepository.findById(eventId)
                .map(event -> {
                    event.setName(updatedEvent.getName());
                    return eventsRepository.save(event);
                })
                .orElse(null);
    }
}
