package ms.tienda.customerAndEmployeeResponse;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeResponse {
    private String message;
    private String codeMessage;
    private List<EmployeeDTO> employeeResponseList;
}
