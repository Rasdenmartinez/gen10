package ms.tienda.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ms.tienda.entity.Proveedor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoResponse {
    private String nombre;
    private Double precio;
    private Proveedor proveedor;
    private Boolean isActive;
}