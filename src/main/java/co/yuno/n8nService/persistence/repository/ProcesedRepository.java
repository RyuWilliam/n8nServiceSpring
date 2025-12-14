package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Procesed;
import co.yuno.n8nService.persistence.enums.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcesedRepository extends JpaRepository<Procesed, Integer> {

    // Ya existente: registros anteriores del mismo proyecto
    List<Procesed> findByProjectNameAndIdProcesedLessThan(String projectName, Integer idProcesed);

    // Todos los registros de un proyecto
    List<Procesed> findByProjectName(String projectName);

    // Todos los registros de un proyecto ordenados por id asc
    List<Procesed> findByProjectNameOrderByIdProcesedAsc(String projectName);

    // Todos los registros de un proyecto ordenados por id desc (últimos primero)
    List<Procesed> findByProjectNameOrderByIdProcesedDesc(String projectName);

    // Buscar por fase
    List<Procesed> findByPhase(Phase phase);

    // Buscar por proyecto y fase
    List<Procesed> findByProjectNameAndPhase(String projectName, Phase phase);

    // Registros anteriores de un proyecto y fase específica
    List<Procesed> findByProjectNameAndPhaseAndIdProcesedLessThan(String projectName, Phase phase, Integer idProcesed);

    // Buscar por fragmento en summary (para análisis con IA si querés filtrar antes)
    List<Procesed> findBySummaryContainingIgnoreCase(String text);

    // Filtrar por flags de riesgo/pago/etc. (contienen texto)
    List<Procesed> findByRiskContainingIgnoreCase(String risk);

    List<Procesed> findByPaymentContainingIgnoreCase(String payment);

    List<Procesed> findByLegalContainingIgnoreCase(String legal);

    List<Procesed> findByTechnicalContainingIgnoreCase(String technical);

    List<Procesed> findByCommercialContainingIgnoreCase(String commercial);

    // Contar registros por proyecto
    long countByProjectName(String projectName);

    // Contar registros por proyecto y fase
    long countByProjectNameAndPhase(String projectName, Phase phase);
}
