package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Processed;
import co.yuno.n8nService.persistence.enums.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcesedRepository extends JpaRepository<Processed, Integer> {

    // Buscar por nombre de proyecto
    List<Processed> findByProjectName(String projectName);

    // Historial de un proyecto ascendente por id
    List<Processed> findByProjectNameOrderByIdProcessedAsc(String projectName);

    // Historial de un proyecto descendente por id
    List<Processed> findByProjectNameOrderByIdProcessedDesc(String projectName);

    // Buscar por fase
    List<Processed> findByPhase(Phase phase);

    // Proyecto + fase
    List<Processed> findByProjectNameAndPhase(String projectName, Phase phase);

    // Búsqueda de texto en summary
    List<Processed> findBySummaryContainingIgnoreCase(String text);

    // Contar por proyecto
    long countByProjectName(String projectName);

    // Contar por proyecto y fase
    long countByProjectNameAndPhase(String projectName, Phase phase);

    // Buscar por merchant ignorando mayúsculas/minúsculas
    List<Processed> findByMerchantIgnoreCase(String merchant);
}
