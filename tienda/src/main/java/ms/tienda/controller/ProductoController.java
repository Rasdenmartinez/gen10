package ms.tienda.controller;

import ms.tienda.entity.Producto;
import ms.tienda.response.Response;
import ms.tienda.service.impl.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @GetMapping("/producto/{id}")
    public ResponseEntity<Response> readById(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.readById(id);
        Producto producto = new Producto();
        if (productoOpt.isPresent()) {
            producto = productoOpt.get();
            Response response = new Response("Éxito", "0", producto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/producto/todos")
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
