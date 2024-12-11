package ms.tienda.repository;

import ms.tienda.entity.Inventario;
import ms.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findByProducto_Id(Long id);

    List<Inventario> findByIsActiveEquals(Boolean isActive);
    //Query
    @Query(value = "SELECT * FROM pedidos p WHERE p.is_active = 1", nativeQuery = true)
    List<Inventario> findByIsActiveTrue();
}
