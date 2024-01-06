package Controller;

import Domain.PC;
import Repo.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pcs")
public class PCController {
    private final PCRepository pcRepository;

    @Autowired
    public PCController(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    @PostMapping
    public PC addPC(@RequestBody PC pc) {
        return pcRepository.save(pc);
    }

    @GetMapping
    public List<PC> getAllPCs() {
        return pcRepository.findAll();
    }

    @GetMapping("/{id}")
    public PC getPCById(@PathVariable int id) {
        return pcRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PC updatePC(@PathVariable int id, @RequestBody PC updatedPC) {
        PC existingPC = pcRepository.findById(id).orElse(null);
        if (existingPC != null) {
            existingPC.setName(updatedPC.getName());
            // You can update other fields if needed
            return pcRepository.save(existingPC);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable int id) {
        pcRepository.deleteById(id);
    }
}
