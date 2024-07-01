package ms.tienda.customerAndEmployeeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    private String nombre;
    private String puesto;
    private String fechaContratacion;
}

