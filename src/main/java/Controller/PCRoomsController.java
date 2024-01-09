package Controller;

import Domain.PCRooms;
import Service.PCRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pcrooms")
public class PCRoomsController {

    @Autowired
    private PCRoomsService pcRoomsService;

    @PostMapping
    public PCRooms addPCRoom(@RequestBody PCRooms pcRoom) {
        return pcRoomsService.addPCRoom(pcRoom);
    }

    @GetMapping
    public List<PCRooms> getAllPCRooms() {
        return pcRoomsService.getAllPCRooms();
    }

    @GetMapping("/{id}")
    public PCRooms getPCRoomById(@PathVariable int id) {
        return pcRoomsService.getPCRoomById(id);
    }

    @PutMapping("/{id}")
    public PCRooms updatePCRoom(@PathVariable int id, @RequestBody PCRooms updatedPCRoom) {
        return pcRoomsService.updatePCRoom(id, updatedPCRoom);
    }

    @DeleteMapping("/{id}")
    public void deletePCRoom(@PathVariable int id) {
        pcRoomsService.deletePCRoom(id);
    }
}
