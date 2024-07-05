package ms.tienda.response;

import lombok.Data;
import java.util.List;

@Data
public class Response {
    private String message;
    private String code;
    private Object data;

    public Response(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public Response(String message, String code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}