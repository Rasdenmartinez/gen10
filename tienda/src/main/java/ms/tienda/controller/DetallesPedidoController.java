package ms.tienda.controller;

import ms.tienda.entity.Detalles_Pedido;
import ms.tienda.service.impl.Detalles_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DetallesPedidoController {
    @Autowired
    Detalles_PedidoService detalles_pedidoService;

    @GetMapping("/detalles_pedidos/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id) {
        Optional<Detalles_Pedido> detalles_pedido = detalles_pedidoService.readById(id);
        if (detalles_pedido.isPresent()) {
            return new ResponseEntity<>(detalles_pedido.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El producto no fue encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/detalles_pedidos")
    public ResponseEntity<List<Detalles_Pedido>> readAll() {
        List<Detalles_Pedido> detalles_pedidos = detalles_pedidoService.readAll();
        if (!detalles_pedidos.isEmpty()) {
            return new ResponseEntity<>(detalles_pedidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/detalles_pedidos")
    public ResponseEntity<Detalles_Pedido> create(@RequestBody Detalles_Pedido detalles_pedido) {
        Detalles_Pedido createdDetelles_Pedido = detalles_pedidoService.create(detalles_pedido);
        return new ResponseEntity<>(createdDetelles_Pedido, HttpStatus.CREATED);
    }

    @PutMapping("/detalles_pedidos")
    public ResponseEntity<Detalles_Pedido> update(@RequestBody Detalles_Pedido detalles_pedido) {
        Detalles_Pedido updateDetalles_Pedidos = detalles_pedidoService.update(detalles_pedido);
        return new ResponseEntity<>(updateDetalles_Pedidos, HttpStatus.OK);
    }

    @DeleteMapping("/detalles_pedidos")
    public ResponseEntity<String> delete(@RequestBody Detalles_Pedido detalles_pedido) {
        try {
            boolean isDeleted = detalles_pedidoService.delete((long) detalles_pedido.getId());
            if (isDeleted) {
                return new ResponseEntity<>("Eliminación exitosa", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Detalles_Pedido no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al eliminar Detalles_Pedido", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}