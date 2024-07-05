package ms.ejercicio1_metodosCrud.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaResponse {
    private String nombre;
    private String direccion;
    private Double m2;

}
