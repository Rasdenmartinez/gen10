package ms.tienda.repository;

import ms.tienda.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    List<Clientes> findByNombre(String nombre);

    @Query(value = "select p.nombre, p.correo_electronico, p.telefono  from clientes p\n" +
            "where p.nombre like %:nombre% ",nativeQuery = true)
    List<Object[]> customerResponse(String nombre);
}
