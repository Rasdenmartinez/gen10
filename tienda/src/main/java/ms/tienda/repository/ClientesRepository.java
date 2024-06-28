package ms.tienda.repository;

import ms.tienda.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    //para poder manipular los datos CRUD
}
