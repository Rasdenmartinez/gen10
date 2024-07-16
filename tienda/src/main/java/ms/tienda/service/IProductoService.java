package ms.tienda.service;

import ms.tienda.entity.Producto;
import ms.tienda.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    public Optional<Producto> readById(Long id);
    public Optional<ProductoResponse> readByIdResponse(Long id);
    public List<Producto> readAll();
    public List<ProductoResponse> readAllResponse();
    public List<Producto> findNombre(String nombre);
    public List<ProductoResponse> findNombreResponse(String nombre);
    public Producto create(Producto producto);
    public Producto update(Producto producto);
    public String delete(Producto producto);
    public List<ProductoResponse> findProductosByProveedorId(Long idProveedor);

}