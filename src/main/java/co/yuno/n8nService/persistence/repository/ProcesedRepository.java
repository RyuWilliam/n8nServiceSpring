package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Procesed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcesedRepository extends JpaRepository<Procesed, Integer> {
}
