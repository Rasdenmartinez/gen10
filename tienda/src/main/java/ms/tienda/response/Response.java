package ms.tienda.response;

import lombok.Data;
import java.util.List;

@Data
public class Response {
    private String message;
    private String code;
    private Object singleData;
    private List<Object> multiData;

    public Response() {}

    public Response(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public Response(String message, String code, Object singleData) {
        this.message = message;
        this.code = code;
        this.singleData = singleData;
    }

    public Response(String message, String code, List<Object> multiData) {
        this.message = message;
        this.code = code;
        this.multiData = multiData;
    }
}