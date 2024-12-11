package ms.tienda.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.tienda.entity.Clientes;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private LocalDate fechaPedido;
    private Clientes cliente;
    private BigDecimal totalPedido;

}
