package ms.tienda.controller;

import ms.tienda.entity.Producto;
import ms.tienda.service.impl.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @GetMapping("/producto/{id}")
    public Optional<Producto> readById(@PathVariable Long id){
        return productoService.readById(id);
    }

    @GetMapping("/producto")
    public List<Producto> readAll(){
        return productoService.readAll();
    }
    @GetMapping("/producto/nombre")
    public List<Producto> findIdProovedor(String nombre){
        return productoService.findNombre(nombre);
    }
    @PostMapping("/producto")
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }

    @PutMapping("/producto")
    public Producto update(@RequestBody Producto producto){
        return productoService.update(producto);
    }

    @DeleteMapping("/producto")
    public String delete(@RequestBody Producto producto){
        return productoService.delete(producto);
    }

}
