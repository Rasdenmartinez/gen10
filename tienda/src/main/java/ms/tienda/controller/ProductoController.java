package ms.tienda.controller;

import ms.tienda.entity.Producto;
import ms.tienda.response.ProductoResponse;
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
        Producto producto;
        if (productoOpt.isPresent()) {
            producto = productoOpt.get();
            Response response = new Response("Éxito", "0", producto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productoResponse/{id}")
    public ResponseEntity<Response> readByIdResponse(@PathVariable Long id) {
        Optional<ProductoResponse> productoOpt = productoService.readByIdResponse(id);
        ProductoResponse productoResponse;
        if (productoOpt.isPresent()) {
            productoResponse = productoOpt.get();
            Response response = new Response("Éxito", "0", productoResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/producto/todos")
    public ResponseEntity<Response> readAll() {
        List<Producto> productos = productoService.readAll();
        if (productos.isEmpty()) {
            Response response = new Response("No se encontraron productos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", productos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/productoResponse/todos")
    public ResponseEntity<Response> readAllResponse() {
        List<ProductoResponse> productosResponse = productoService.readAllResponse();
        if (productosResponse.isEmpty()) {
            Response response = new Response("No se encontraron productos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", productosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/producto/nombre")
    public ResponseEntity<Response> findNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.findNombre(nombre);
        if (productos.isEmpty()) {
            Response response = new Response("No se encontraron productos con el nombre proporcionado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", productos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/productoResponse/nombre")
    public ResponseEntity<Response> findNombreResponse(@RequestParam String nombre) {
        List<ProductoResponse> productosResponse = productoService.findNombreResponse(nombre);
        if (productosResponse.isEmpty()) {
            Response response = new Response("No se encontraron productos con el nombre proporcionado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", productosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/producto")
    public ResponseEntity<Response> create(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.create(producto);
            Response response = new Response("Producto creado con éxito", "0", nuevoProducto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Response response = new Response("Error al crear el producto", "1");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/producto")
    public ResponseEntity<Response> update(@RequestBody Producto producto) {
        Optional<Producto> productoOpt = productoService.readById(producto.getId());
        if (productoOpt.isPresent()) {
            Producto productoActualizado = productoService.update(producto);
            Response response = new Response("Producto actualizado con éxito", "0", productoActualizado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Producto no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/producto")
    public ResponseEntity<Response> delete(@RequestBody Producto producto) {
        Optional<Producto> productoOpt = productoService.readById(producto.getId());
        if (productoOpt.isPresent()) {
            String resultado = productoService.delete(producto);
            Response response = new Response(resultado, "0");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Producto no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productoResponseIdProveedorQuery/{id}")
    public ResponseEntity<Response> findByProveedorIdResponse(@PathVariable Long id){
        List<ProductoResponse> productosResponse = productoService.findProductosByProveedorId(id);
        if (productosResponse.isEmpty()) {
            Response response = new Response("No se encontraron productos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", productosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
