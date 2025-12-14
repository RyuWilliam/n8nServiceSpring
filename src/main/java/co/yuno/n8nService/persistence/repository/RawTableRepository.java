package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.RawTable;
import co.yuno.n8nService.persistence.enums.InfoSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RawTableRepository extends JpaRepository<RawTable, Integer> {

    // Buscar por source
    List<RawTable> findBySource(InfoSource source);

    // Buscar por país (ignorando mayúsculas/minúsculas)
    List<RawTable> findByCountryIgnoreCase(String country);

    // Buscar por merchent exacto
    List<RawTable> findByMerchent(String merchent);

    // Buscar por merchent que contenga texto (like %texto%)
    List<RawTable> findByMerchentContainingIgnoreCase(String merchent);

    // Buscar por rango de fechas
    List<RawTable> findByDateBetween(LocalDateTime start, LocalDateTime end);

    // Buscar por source y país
    List<RawTable> findBySourceAndCountryIgnoreCase(InfoSource source, String country);

    // Buscar por snippet que contenga texto
    List<RawTable> findBySnippetContainingIgnoreCase(String text);

    // Contar por source
    long countBySource(InfoSource source);

    // Contar por país
    long countByCountryIgnoreCase(String country);

    // Traer últimos N registros por fecha (paginable, usar Pageable en el service/controller)
    List<RawTable> findByCountryIgnoreCaseOrderByDateDesc(String country);
}
