package ms.tienda.mapper;

import org.mapstruct.Mapper;
import ms.tienda.entity.Producto;
import ms.tienda.response.ProductoResponse;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductoMapper {

    @Mapping(source = "id_proveedor", target = "proveedor")
    ProductoResponse toProductoResponse(Producto producto);

    List<ProductoResponse> toProductoResponseList(List<Producto> productos);
}