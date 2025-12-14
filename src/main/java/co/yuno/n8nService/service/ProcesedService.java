package co.yuno.n8nService.service;

import co.yuno.n8nService.persistence.entity.Procesed;
import co.yuno.n8nService.persistence.enums.Phase;
import co.yuno.n8nService.persistence.repository.ProcesedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcesedService {

    private final ProcesedRepository repository;

    public ProcesedService(ProcesedRepository repository) {
        this.repository = repository;
    }

    // CRUD
    public Procesed save(Procesed procesed) {
        return repository.save(procesed);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public Procesed findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Procesed> findAll() {
        return repository.findAll();
    }

    // Búsquedas
    public List<Procesed> findByProjectName(String projectName) {
        return repository.findByProjectName(projectName);
    }

    public List<Procesed> findHistoryAsc(String projectName) {
        return repository.findByProjectNameOrderByIdProcesedAsc(projectName);
    }

    public List<Procesed> findHistoryDesc(String projectName) {
        return repository.findByProjectNameOrderByIdProcesedDesc(projectName);
    }

    public List<Procesed> findByPhase(Phase phase) {
        return repository.findByPhase(phase);
    }

    public List<Procesed> findByProjectAndPhase(String projectName, Phase phase) {
        return repository.findByProjectNameAndPhase(projectName, phase);
    }

    public List<Procesed> searchInSummary(String text) {
        return repository.findBySummaryContainingIgnoreCase(text);
    }

    public long countByProjectName(String projectName) {
        return repository.countByProjectName(projectName);
    }

    public long countByProjectNameAndPhase(String projectName, Phase phase) {
        return repository.countByProjectNameAndPhase(projectName, phase);
    }
}
