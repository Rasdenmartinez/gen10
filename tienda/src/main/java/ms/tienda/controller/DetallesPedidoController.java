package ms.tienda.controller;

import ms.tienda.details_orders.DetailsOrdersDTO;
import ms.tienda.details_orders.DetailsOrdersResponse;
import jakarta.websocket.server.PathParam;
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
    Detalles_PedidoService detallesPedidoService;

    @GetMapping("/detalles_pedidos/{id}")
    public Optional<Detalles_Pedido> readById(@PathVariable Long id) {
        return detallesPedidoService.readById(id);
    }

    @GetMapping("/detalles_pedidos")
    public List<Detalles_Pedido> detallesPedidos() {
        return detallesPedidoService.readAll();
    }

    @PostMapping("/detalles_pedidos")
    public Detalles_Pedido create(@RequestBody Detalles_Pedido detalles_pedido) {
        return detallesPedidoService.create(detalles_pedido);
    }

    @PutMapping("/detalles_pedidos/")
    public Detalles_Pedido update(@RequestBody Detalles_Pedido detalles_pedido) {
        return detallesPedidoService.update(detalles_pedido);
    }

    @DeleteMapping("/detalles_pedidos/{id}")
    public String delete(@PathVariable Long id) {
        Detalles_Pedido detalles_pedido = new Detalles_Pedido();
        detalles_pedido.setId(id);
        return detallesPedidoService.delete(detalles_pedido);
    }

    @GetMapping("/detalles_pedidos/response")
    public ResponseEntity<DetailsOrdersResponse> responseQuery(@PathParam("id") String id){
        List<DetailsOrdersDTO> detailsOrdersResponseList=detallesPedidoService.response(id);
        DetailsOrdersResponse response;
        if(detailsOrdersResponseList.isEmpty()){
            response=DetailsOrdersResponse.builder()
                    .message("Not Found, verify your parameters")
                    .codeMessage("1005")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else{
            response=DetailsOrdersResponse.builder()
                    .message("Succes")
                    .codeMessage("0")
                    .detailsordersResponseList(detailsOrdersResponseList)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}