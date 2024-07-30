package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Pedido;
import ms.tienda.mapper.PedidoMapper;
import ms.tienda.repository.PedidoRepository;
import ms.tienda.response.PedidoResponse;
import ms.tienda.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PedidoService implements IPedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public Optional<Pedido> readById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Optional<PedidoResponse> readByIdResponse(Long id) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        return pedidoOpt.map(pedidoMapper::toPedidoResponse);
    }

    @Override
    public List<Pedido> readAll() {
        return pedidoRepository.findAll().stream().filter(s -> s.getIsActive()).toList();
    }

    @Override
    public List<PedidoResponse> readAllResponse() {
        List<Pedido> pedidos = pedidoRepository.findAll().stream().filter(s->s.getIsActive()).toList();
        return pedidoMapper.toPedidoResponseList(pedidos);
    }

    @Override
    public List<Pedido> findFechaPedido(LocalDate fecha) {
        return pedidoRepository.findByFechaPedidoEquals(fecha);
    }

    @Override
    public List<PedidoResponse> findFechaPedidoResponse(LocalDate fecha) {
        List<Pedido> pedidos = pedidoRepository.findByFechaPedidoEquals(fecha);
        return pedidoMapper.toPedidoResponseList(pedidos);
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public String delete(Pedido pedido) {
        if(pedido.equals(pedidoRepository.findById(pedido.getId()).orElse(null))){
            pedido.setIsActive(false);
            pedidoRepository.save(pedido);
            return "Pedido eliminado";
        } else
            return "Pedido no encontrado";
    }

    @Override
    public List<PedidoResponse> findPedidosByClienteId(Long idCliente) {
        List<Pedido> pedidos = pedidoRepository.findPedidosByClienteId(idCliente);
        return pedidoMapper.toPedidoResponseList(pedidos);
    }
}
