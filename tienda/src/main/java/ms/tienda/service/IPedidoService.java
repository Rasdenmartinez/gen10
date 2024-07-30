package ms.tienda.service;

import ms.tienda.entity.Pedido;
import ms.tienda.entity.Producto;
import ms.tienda.response.PedidoResponse;
import ms.tienda.response.ProductoResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPedidoService {

    public Optional<Pedido> readById(Long id);
    public Optional<PedidoResponse> readByIdResponse(Long id);
    public List<Pedido> readAll();
    public List<PedidoResponse> readAllResponse();
    public List<Pedido> findFechaPedido(LocalDate fechae);
    public List<PedidoResponse> findFechaPedidoResponse(LocalDate fecha);
    public Pedido create(Pedido pedido);
    public Pedido update(Pedido pedido);
    public String delete(Pedido pedido);
    public List<PedidoResponse> findPedidosByClienteId(Long idCliente);

}
