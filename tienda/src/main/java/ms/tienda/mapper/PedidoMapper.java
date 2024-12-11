package ms.tienda.mapper;

import ms.tienda.entity.Pedido;
import ms.tienda.response.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "cliente", target = "cliente")
    PedidoResponse toPedidoResponse(Pedido pedido);

    List<PedidoResponse> toPedidoResponseList(List<Pedido> pedidos);

}
