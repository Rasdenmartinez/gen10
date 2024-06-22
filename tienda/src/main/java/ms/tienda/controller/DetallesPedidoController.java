package ms.tienda.controller;

import ms.tienda.entity.Detalles_Pedido;
import ms.tienda.service.impl.Detalles_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DetallesPedidoController {
    @Autowired
    Detalles_PedidoService detalles_pedidoService;
    @GetMapping("/detalles_pedido/{id}")
    public Optional<Detalles_Pedido> readById(@PathVariable Long id){
        return detalles_pedidoService.readById(id);
    }

    @GetMapping("/detalles_pedido/todos")
    public List<Detalles_Pedido> readAll(){
        return detalles_pedidoService.readAll();
    }
    @PostMapping("/detalles_pedid")
    public Detalles_Pedido create(@RequestBody Detalles_Pedido detalles_pedido){
        return detalles_pedidoService.create(detalles_pedido);
    }

    @PutMapping("/detalles_pedido")
    public Detalles_Pedido update(@RequestBody Detalles_Pedido detalles_pedido){
        return detalles_pedidoService.update(detalles_pedido);
    }

    @DeleteMapping("/detalles_pedidos")
    public String delete(@RequestBody Detalles_Pedido detalles_pedido) {
        detalles_pedidoService.delete((long) detalles_pedido.getId());
        return "Eliminacion exitosa";
    }

}