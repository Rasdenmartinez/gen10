package ms.ejercicio1_metodosCrud.repository;

import ms.ejercicio1_metodosCrud.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
