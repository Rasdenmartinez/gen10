package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalles_pedidos")
public class Detalles_Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "pedido")
    private int pedido;
    @Column(name = "producto")
    private int producto;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precio_unitario;
}
