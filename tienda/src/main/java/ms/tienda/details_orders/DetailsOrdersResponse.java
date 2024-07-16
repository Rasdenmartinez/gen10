package ms.tienda.details_orders;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DetailsOrdersResponse {
    private String message;
    private String codeMessage;
    private List<DetailsOrdersDTO> detailsordersResponseList;
}
