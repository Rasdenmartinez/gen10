package ms.tienda.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoResponse {
    private String nombre;
    private Double precio;
    private Long id_proveedor;
    private Boolean isActive;
}