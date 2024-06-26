package ms.tienda.service;

import ms.tienda.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public Optional<Producto> readById(Long id);
    public List<Producto> readAll();
    public List<Producto> findNombre(String nombre);
    public Producto create(Producto producto);
    public Producto update(Producto producto);
    public String delete(Producto producto);
}