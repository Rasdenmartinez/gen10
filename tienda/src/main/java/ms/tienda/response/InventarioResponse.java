package ms.tienda.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.tienda.entity.Producto;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioResponse {

    private Producto producto;
    private Integer stock;

}
