package Controller;

import Domain.Events;
import Repo.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    @GetMapping("/{eventId}")
    public Events getEventById(@PathVariable Long eventId) {
        return eventsRepository.findById(eventId).orElse(null);
    }

    @PostMapping
    public void addEvent(@RequestBody Events event) {
        eventsRepository.save(event);
    }

    @GetMapping("/findByName/{name}")
    public List<Events> getEventsByName(@PathVariable String name) {
        return eventsRepository.findByName(name);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventsRepository.deleteById(eventId);
    }

    @PutMapping("/{eventId}")
    public Events updateEvent(@PathVariable Long eventId, @RequestBody Events updatedEvent) {
        return eventsRepository.findById(eventId)
                .map(event -> {
                    event.setName(updatedEvent.getName());
                    return eventsRepository.save(event);
                })
                .orElse(null);
    }

}
