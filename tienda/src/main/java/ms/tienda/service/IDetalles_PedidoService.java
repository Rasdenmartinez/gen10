package ms.tienda.service;

import ms.tienda.entity.Detalles_Pedido;

import java.util.List;
import java.util.Optional;

public interface IDetalles_PedidoService {
    public Optional<Detalles_Pedido> readById(Long id);
    public List<Detalles_Pedido> readAll();
    public Detalles_Pedido create(Detalles_Pedido detalles_pedido);
    public Detalles_Pedido update(Detalles_Pedido detalles_pedido);
    public String delete(Detalles_Pedido detalles_pedido);
}