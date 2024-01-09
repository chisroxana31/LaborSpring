package Service;

import Domain.PCRooms;
import Repo.PCRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCRoomsService {

    @Autowired
    private PCRoomsRepository pcRoomRepository;


    public PCRooms addPCRoom(PCRooms pcRoom) {
        return pcRoomRepository.save(pcRoom);
    }


    public List<PCRooms> getAllPCRooms() {
        return pcRoomRepository.findAll();
    }


    public PCRooms getPCRoomById(int id) {
        return pcRoomRepository.findById(id).orElse(null);
    }


    public PCRooms updatePCRoom(int id, PCRooms updatedPCRoom) {
        PCRooms existingPCRoom = pcRoomRepository.findById(id).orElse(null);
        if (existingPCRoom != null) {
            existingPCRoom.setName(updatedPCRoom.getName());
            existingPCRoom.setLibrary(updatedPCRoom.getLibrary());
            return pcRoomRepository.save(existingPCRoom);
        }
        return null;
    }


    public void deletePCRoom(int id) {
        pcRoomRepository.deleteById(id);
    }
}
