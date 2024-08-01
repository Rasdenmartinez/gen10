package ms.tienda.controller;

import ms.tienda.entity.Inventario;
import ms.tienda.response.InventarioResponse;
import ms.tienda.response.Response;
import ms.tienda.service.impl.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;
    @GetMapping("/inventario/{id}")
    public ResponseEntity<Response> readById(@PathVariable Long id) {
        Optional<Inventario> inventarioOpt = inventarioService.readById(id);
        Inventario inventario;
        if (inventarioOpt.isPresent()) {
            inventario = inventarioOpt.get();
            Response response = new Response("Éxito", "0", inventario);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/inventarioResponse/{id}")
    public ResponseEntity<Response> readByIdResponse(@PathVariable Long id) {
        Optional<InventarioResponse> inventarioOpt = inventarioService.readByIdResponse(id);
        InventarioResponse inventarioResponse;
        if (inventarioOpt.isPresent()) {
            inventarioResponse = inventarioOpt.get();
            Response response = new Response("Éxito", "0", inventarioResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/inventario/todos")
    public ResponseEntity<Response> readAll() {
        List<Inventario> inventarios = inventarioService.readAll();
        if (inventarios.isEmpty()) {
            Response response = new Response("No se encontraron inventarios", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", inventarios);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/inventarioResponse/todos")
    public ResponseEntity<Response> readAllResponse() {
        List<InventarioResponse> inventariosResponse = inventarioService.readAllResponse();
        if (inventariosResponse.isEmpty()) {
            Response response = new Response("No se encontraron inventarios", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", inventariosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/inventario/isActive")
    public ResponseEntity<Response> findIsActive(@RequestParam Boolean isActive) {
        List<Inventario> inventarios = inventarioService.findIsActive(isActive);
        if (inventarios.isEmpty()) {
            Response response = new Response("No se encontraron inventarios", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", inventarios);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/inventarioResponse/isActive")
    public ResponseEntity<Response> findIsActiveResponse(@RequestParam Boolean isActive) {
        List<InventarioResponse> inventariosResponse = inventarioService.findIsActiveResponse(isActive);
        if (inventariosResponse.isEmpty()) {
            Response response = new Response("No se encontraron inventarios", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", inventariosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/inventario")
    public ResponseEntity<Response> create(@RequestBody Inventario inventario) {
        try {
            Inventario nuevoInventario = inventarioService.create(inventario);
            Response response = new Response("Inventario creado con éxito", "0", nuevoInventario);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Response response = new Response("Error al crear el inventario", "1");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/inventario")
    public ResponseEntity<Response> update(@RequestBody Inventario inventario) {
        Optional<Inventario> inventarioOpt = inventarioService.readById(inventario.getId());
        if (inventarioOpt.isPresent()) {
            Inventario inventarioActualizado = inventarioService.update(inventario);
            Response response = new Response("Inventario actualizado con éxito", "0", inventarioActualizado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Inventario no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/inventario")
    public ResponseEntity<Response> delete(@RequestBody Inventario inventario) {
        Optional<Inventario> inventarioOpt = inventarioService.readById(inventario.getId());
        if (inventarioOpt.isPresent()) {
            String resultado = inventarioService.delete(inventario);
            Response response = new Response(resultado, "0");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Inventario no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/inventarioResponseIsActiveTrueQuery/{id}")
    public ResponseEntity<Response> findByIsActiveTrue() {
        List<InventarioResponse> inventariosResponse = inventarioService.findByIsActiveTrue();
        if (inventariosResponse.isEmpty()) {
            Response response = new Response("No se encontraron inventarios", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", inventariosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
