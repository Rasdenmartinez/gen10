package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Detalles_Pedido;
import ms.tienda.repository.Detalles_PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class Detalles_PedidoService {
    @Autowired
    Detalles_PedidoRepository detalles_pedidoRepository;

    public Optional<Detalles_Pedido> readById(Long id) {
        return detalles_pedidoRepository.findById(id);
    }

    public List<Detalles_Pedido> readAll() {
        return detalles_pedidoRepository.findAll();
    }

    public Detalles_Pedido create(Detalles_Pedido detalles_pedido) {
        return detalles_pedidoRepository.save(detalles_pedido);
    }
    public Detalles_Pedido update(Detalles_Pedido detalles_pedido) {
        return detalles_pedidoRepository.save(detalles_pedido);
    }
    public void delete(Long id) {
        detalles_pedidoRepository.deleteById(id);
    }

}
