package ms.ejercicio1_metodosCrud.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Response {
    private String message;
    private String code;
    private List<PersonaResponse> personaResponseList;
}
