package ms.tienda.repository;

import ms.tienda.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    //manipulacion del CRUD
}
