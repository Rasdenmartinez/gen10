package ms.tienda.repository;

import ms.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    @Query(value = "SELECT * FROM productos p WHERE p.id_proveedor = ?1", nativeQuery = true)
    List<Producto> findProductosByProveedorId(Long id);

}
