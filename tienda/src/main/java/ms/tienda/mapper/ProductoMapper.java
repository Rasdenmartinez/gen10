package ms.tienda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ms.tienda.entity.Producto;
import ms.tienda.response.ProductoResponse;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoResponse toProductoResponse(Producto producto);
}