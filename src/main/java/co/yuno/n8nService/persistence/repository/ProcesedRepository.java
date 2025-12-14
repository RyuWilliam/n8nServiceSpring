package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Procesed;
import co.yuno.n8nService.persistence.enums.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcesedRepository extends JpaRepository<Procesed, Integer> {

    // Buscar por nombre de proyecto
    List<Procesed> findByProjectName(String projectName);

    // Historial de un proyecto ascendente por id
    List<Procesed> findByProjectNameOrderByIdProcesedAsc(String projectName);

    // Historial de un proyecto descendente por id
    List<Procesed> findByProjectNameOrderByIdProcesedDesc(String projectName);

    // Buscar por fase
    List<Procesed> findByPhase(Phase phase);

    // Proyecto + fase
    List<Procesed> findByProjectNameAndPhase(String projectName, Phase phase);

    // Búsqueda de texto en summary
    List<Procesed> findBySummaryContainingIgnoreCase(String text);

    // Contar por proyecto
    long countByProjectName(String projectName);

    // Contar por proyecto y fase
    long countByProjectNameAndPhase(String projectName, Phase phase);
}
