package ms.tienda.repository;

import feign.Param;
import ms.tienda.entity.Detalles_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface Detalles_PedidoRepository extends JpaRepository<Detalles_Pedido, Long> {

    @Query(value = "SELECT p.id, k.fecha_del_pedido, d.descripcion_producto, p.cantidad, p.precio_unitario " +
            "FROM detalles_pedidos p " +
            "INNER JOIN productos d ON p.producto = d.id " +
            "INNER JOIN pedidos k ON p.pedido = k.id " +
            "WHERE p.id LIKE :id", nativeQuery = true)
    List<Object[]> detailsordersResponse(@Param("id") String id);

}
