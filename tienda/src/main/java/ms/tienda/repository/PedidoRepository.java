package ms.tienda.repository;

import ms.tienda.entity.Pedido;
import ms.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByFechaPedidoEquals(LocalDate fechaPedido);
    //Query
    @Query(value = "SELECT * FROM pedidos p WHERE p.cliente_id = ?1", nativeQuery = true)
    List<Pedido> findPedidosByClienteId(Long id);
}
