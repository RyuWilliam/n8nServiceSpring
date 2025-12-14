package co.yuno.n8nService.web.controller;

import co.yuno.n8nService.persistence.entity.Procesed;
import co.yuno.n8nService.persistence.enums.Phase;
import co.yuno.n8nService.service.ProcesedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesed")
public class ProcesedController {

    private final ProcesedService service;

    public ProcesedController(ProcesedService service) {
        this.service = service;
    }

    // CRUD básico
    @GetMapping("/{id}")
    public Procesed getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Procesed> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Procesed create(@RequestBody Procesed procesed) {
        return service.save(procesed);
    }

    @PutMapping("/{id}")
    public Procesed update(@PathVariable Integer id, @RequestBody Procesed procesed) {
        procesed.setIdProcesed(id);
        return service.save(procesed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    // Búsquedas
    @GetMapping("/by-project")
    public List<Procesed> getByProject(@RequestParam String projectName) {
        return service.findByProjectName(projectName);
    }

    @GetMapping("/history-asc")
    public List<Procesed> getHistoryAsc(@RequestParam String projectName) {
        return service.findHistoryAsc(projectName);
    }

    @GetMapping("/history-desc")
    public List<Procesed> getHistoryDesc(@RequestParam String projectName) {
        return service.findHistoryDesc(projectName);
    }

    @GetMapping("/by-phase")
    public List<Procesed> getByPhase(@RequestParam Phase phase) {
        return service.findByPhase(phase);
    }

    @GetMapping("/by-project-and-phase")
    public List<Procesed> getByProjectAndPhase(@RequestParam String projectName,
                                               @RequestParam Phase phase) {
        return service.findByProjectAndPhase(projectName, phase);
    }

    @GetMapping("/search-summary")
    public List<Procesed> searchInSummary(@RequestParam String text) {
        return service.searchInSummary(text);
    }
}
