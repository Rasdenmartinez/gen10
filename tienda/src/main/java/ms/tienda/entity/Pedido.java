package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_del_pedido")
    private LocalDate fechaPedido;
    @ManyToOne
    @JoinColumn(name= "cliente_id")
    private Clientes cliente;
    @Column(name = "total_pedido", precision = 10, scale = 2)
    private BigDecimal totalPedido;
    @Column(name = "is_active")
    private Boolean isActive;

}
