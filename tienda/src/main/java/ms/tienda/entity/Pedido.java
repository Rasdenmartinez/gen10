package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "fecha_del_pedido")
    private LocalDate fecha_del_pedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @Column(name = "total_pedido", precision = 10, scale = 2)
    private BigDecimal totalPedido;

}