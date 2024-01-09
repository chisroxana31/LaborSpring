package Controller;

import Domain.PC;
import Service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pcs")
public class PCController {

    @Autowired
    private PCService pcService;

    @PostMapping
    public PC addPC(@RequestBody PC pc) {
        return pcService.addPC(pc);
    }

    @GetMapping
    public List<PC> getAllPCs() {
        return pcService.getAllPCs();
    }

    @GetMapping("/{id}")
    public PC getPCById(@PathVariable int id) {
        return pcService.getPCById(id);
    }

    @PutMapping("/{id}")
    public PC updatePC(@PathVariable int id, @RequestBody PC updatedPC) {
        return pcService.updatePC(id, updatedPC);
    }

    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable int id) {
        pcService.deletePC(id);
    }
}
