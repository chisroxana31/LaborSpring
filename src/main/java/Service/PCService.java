package Service;

import Domain.PC;
import Repo.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCService {

    @Autowired
    private PCRepository pcRepository;


    public PC addPC(PC pc) {
        return pcRepository.save(pc);
    }


    public List<PC> getAllPCs() {
        return pcRepository.findAll();
    }


    public PC getPCById(int id) {
        return pcRepository.findById(id).orElse(null);
    }


    public PC updatePC(int id, PC updatedPC) {
        PC existingPC = pcRepository.findById(id).orElse(null);
        if (existingPC != null) {
            existingPC.setName(updatedPC.getName());
            existingPC.setPCRoom(updatedPC.getPCRoom());
            // You can update other fields if needed
            return pcRepository.save(existingPC);
        }
        return null;
    }


    public void deletePC(int id) {
        pcRepository.deleteById(id);
    }
}