package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Producto;
import ms.tienda.repository.ProductoRepository;
import ms.tienda.response.ProductoResponse;
import ms.tienda.mapper.ProductoMapper;
import ms.tienda.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoService implements IProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;


    @Override
    public Optional<Producto> readById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Optional<ProductoResponse> readByIdResponse(Long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        return productoOpt.map(productoMapper::toProductoResponse);
    }

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll().stream().filter(s->s.getIsActive()).toList();
    }

    @Override
    public List<ProductoResponse> readAllResponse() {
        List<Producto> productos = productoRepository.findAll().stream().filter(s->s.getIsActive()).toList();
        return productoMapper.toProductoResponseList(productos);
    }

    @Override
    public List<Producto> findNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<ProductoResponse> findNombreResponse(String nombre) {
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        return productoMapper.toProductoResponseList(productos);
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public String delete(Producto producto) {
        if(producto.equals(productoRepository.findById(producto.getId()).orElse(null))){
            producto.setIsActive(false);
            productoRepository.save(producto);
            return "Producto eliminado";
        } else
            return "Producto no encontrado";
    }

    @Override
    public List<ProductoResponse> findProductosByProveedorId(Long idProveedor) {
        List<Producto> productos = productoRepository.findProductosByProveedorId(idProveedor);
        return productoMapper.toProductoResponseList(productos);
    }

}