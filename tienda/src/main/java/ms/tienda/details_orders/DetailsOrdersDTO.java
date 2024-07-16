package ms.tienda.details_orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ms.tienda.entity.Producto;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DetailsOrdersDTO {
    private Long id;
    private LocalDate fechaDelPedido;
    private String descripcionProducto;
    private int cantidad;
    private double precioUnitario;

}
