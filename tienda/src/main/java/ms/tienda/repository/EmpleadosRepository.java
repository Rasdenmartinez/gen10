package ms.tienda.repository;

import ms.tienda.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    //parametrizadas
    List<Empleados> findByNombre(String nombre);

    @Query(value = "select p.nombre, p.puesto, p.fecha_contratacion  from empleados p\n" +
            "where p.nombre like %:nombre% ",nativeQuery = true)
    List<Object[]> employeeResponse(String nombre);
}
