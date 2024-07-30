package ms.tienda.mapper;

import ms.tienda.entity.Inventario;
import ms.tienda.entity.Pedido;
import ms.tienda.response.InventarioResponse;
import ms.tienda.response.PedidoResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioResponse toInventarioResponse(Inventario inventario);

    List<InventarioResponse> toInventarioResponseList(List<Inventario> inventarioList);
}
