package Controller;

import Domain.Events;
import Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Events getEventById(@PathVariable Long eventId) {
        return eventsService.getEventById(eventId);
    }

    @PostMapping
    public void addEvent(@RequestBody Events event) {
        eventsService.addEvent(event);
    }

    @GetMapping("/findByName/{name}")
    public List<Events> getEventsByName(@PathVariable String name) {
        return eventsService.getEventsByName(name);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventsService.deleteEvent(eventId);
    }

    @PutMapping("/{eventId}")
    public Events updateEvent(@PathVariable Long eventId, @RequestBody Events updatedEvent) {
        return eventsService.updateEvent(eventId, updatedEvent);
    }
}