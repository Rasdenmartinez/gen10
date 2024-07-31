package ms.tienda.repository;

import ms.tienda.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    List<Inventario> findByIsActiveEquals(Boolean isActive);
    //Query
    @Query(value = "SELECT * FROM pedidos p WHERE p.is_active = true", nativeQuery = true)
    List<Inventario> findByIsActiveTrue();
}
