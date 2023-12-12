package Controller;

import Domain.PCRooms;
import Repo.PCRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pcrooms")
public class PCRoomsController {
    private final PCRoomsRepository pcRoomRepository;

    @Autowired
    public PCRoomsController(PCRoomsRepository pcRoomRepository) {
        this.pcRoomRepository = pcRoomRepository;
    }

    @PostMapping
    public PCRooms addPCRoom(@RequestBody PCRooms pcRoom) {
        return pcRoomRepository.save(pcRoom);
    }

    @GetMapping
    public List<PCRooms> getAllPCRooms() {
        return pcRoomRepository.findAll();
    }

    @GetMapping("/{id}")
    public PCRooms getPCRoomById(@PathVariable int id) {
        return pcRoomRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PCRooms updatePCRoom(@PathVariable int id, @RequestBody PCRooms updatedPCRoom) {
        PCRooms existingPCRoom = pcRoomRepository.findById(id).orElse(null);
        if (existingPCRoom != null) {
            existingPCRoom.setName(updatedPCRoom.getName());
            existingPCRoom.setLibrary(updatedPCRoom.getLibrary());
            return pcRoomRepository.save(existingPCRoom);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePCRoom(@PathVariable int id) {
        pcRoomRepository.deleteById(id);
    }
}
