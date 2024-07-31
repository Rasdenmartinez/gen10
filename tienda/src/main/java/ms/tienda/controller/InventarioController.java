package ms.tienda.controller;

import ms.tienda.entity.Inventario;
import ms.tienda.response.Response;
import ms.tienda.service.impl.InventarioService;
import ms.tienda.service.impl.PedidoService;
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
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Response> readById(@PathVariable Long id) {
        Optional<Pedido> pedidoOpt = pedidoService.readById(id);
        Pedido pedido;
        if (pedidoOpt.isPresent()) {
            pedido = pedidoOpt.get();
            Response response = new Response("Éxito", "0", pedido);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pedidoResponse/{id}")
    public ResponseEntity<Response> readByIdResponse(@PathVariable Long id) {
        Optional<PedidoResponse> pedidoOpt = pedidoService.readByIdResponse(id);
        PedidoResponse pedidoResponse;
        if (pedidoOpt.isPresent()) {
            pedidoResponse = pedidoOpt.get();
            Response response = new Response("Éxito", "0", pedidoResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("No encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pedido/todos")
    public ResponseEntity<Response> readAll() {
        List<Pedido> pedidos = pedidoService.readAll();
        if (pedidos.isEmpty()) {
            Response response = new Response("No se encontraron pedidos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", pedidos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/pedidoResponse/todos")
    public ResponseEntity<Response> readAllResponse() {
        List<PedidoResponse> pedidosResponse = pedidoService.readAllResponse();
        if (pedidosResponse.isEmpty()) {
            Response response = new Response("No se encontraron pedidos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", pedidosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/pedido/fecha")
    public ResponseEntity<Response> findFechaPedido(@RequestParam LocalDate fecha) {
        List<Pedido> pedidos = pedidoService.findFechaPedido(fecha);
        if (pedidos.isEmpty()) {
            Response response = new Response("No se encontraron pedidos con la fecha proporcionada", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", pedidos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/pedidoResponse/fecha")
    public ResponseEntity<Response> findFechaPedidoResponse(@RequestParam LocalDate fecha) {
        List<PedidoResponse> pedidosResponse = pedidoService.findFechaPedidoResponse(fecha);
        if (pedidosResponse.isEmpty()) {
            Response response = new Response("No se encontraron pedidos con la fecha proporcionada", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", pedidosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/pedido")
    public ResponseEntity<Response> create(@RequestBody Pedido pedido) {
        try {
            Pedido nuevoPedido = pedidoService.create(pedido);
            Response response = new Response("Pedido creado con éxito", "0", nuevoPedido);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Response response = new Response("Error al crear el pedido", "1");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pedido")
    public ResponseEntity<Response> update(@RequestBody Pedido pedido) {
        Optional<Pedido> pedidoOpt = pedidoService.readById(pedido.getId());
        if (pedidoOpt.isPresent()) {
            Pedido pedidoActualizado = pedidoService.update(pedido);
            Response response = new Response("Pedido actualizado con éxito", "0", pedidoActualizado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Pedido no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pedido")
    public ResponseEntity<Response> delete(@RequestBody Pedido pedido) {
        Optional<Pedido> pedidoOpt = pedidoService.readById(pedido.getId());
        if (pedidoOpt.isPresent()) {
            String resultado = pedidoService.delete(pedido);
            Response response = new Response(resultado, "0");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response("Pedido no encontrado", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pedidoResponseIdClienteQuery/{id}")
    public ResponseEntity<Response> findByClienteIdResponse(@PathVariable Long id){
        List<PedidoResponse> pedidosResponse = pedidoService.findPedidosByClienteId(id);
        if (pedidosResponse.isEmpty()) {
            Response response = new Response("No se encontraron pedidos", "1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Response response = new Response("Éxito", "0", pedidosResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
