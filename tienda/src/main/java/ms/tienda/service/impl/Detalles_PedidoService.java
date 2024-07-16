package ms.tienda.service.impl;

import ms.tienda.details_orders.DetailsOrdersDTO;
import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Detalles_Pedido;
import ms.tienda.repository.Detalles_PedidoRepository;
import ms.tienda.service.IDetalles_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class Detalles_PedidoService implements IDetalles_PedidoService {

    @Autowired
    Detalles_PedidoRepository detallesPedidoRepository;

    @Override
    public List<Detalles_Pedido> readAll() {
        return detallesPedidoRepository.findAll();
    }
   @Override
    public Optional<Detalles_Pedido> readById(Long id) {
        return detallesPedidoRepository.findById(id);
    }

    @Override
    public Detalles_Pedido create(Detalles_Pedido detalles_pedido) {
        return detallesPedidoRepository.save(detalles_pedido);
    }

    @Override
    public Detalles_Pedido update(Detalles_Pedido detalles_pedido) {
        return detallesPedidoRepository.save(detalles_pedido);
    }

    @Override
    public String delete(Detalles_Pedido detalles_pedido) {
        Optional<Detalles_Pedido> detallesPedidoOpt = detallesPedidoRepository.findById(detalles_pedido.getId());
        if (detallesPedidoOpt.isPresent()) {
            try {
                detallesPedidoRepository.deleteById(detalles_pedido.getId());
                return "Detalles del pedido " + detalles_pedido.getId() + ", borrado correctamente";
            } catch (Exception ex) {
                log.error("Error " + ex.getMessage());
                log.error("Rastreo ", ex);
                return "Ocurrió un error con la base de datos";
            }
        } else {
            return "Detalles del pedido " + detalles_pedido.getId() + " no se encontraron";
        }
    }

    @Override
    public List<DetailsOrdersDTO> response(String id) {
        List<Object[]> objectList = detallesPedidoRepository.detailsordersResponse(id);
        List<DetailsOrdersDTO> detailsordersList = objectList.stream().map(s -> {
            DetailsOrdersDTO detailsordersResponse = new DetailsOrdersDTO();
            detailsordersResponse.setId(Long.parseLong(s[0].toString()));
            detailsordersResponse.setFechaDelPedido(LocalDate.parse(s[1].toString())); // Ajusta según el formato de fecha
            detailsordersResponse.setDescripcionProducto(s[2].toString());
            detailsordersResponse.setCantidad(Integer.parseInt(s[3].toString()));
            detailsordersResponse.setPrecioUnitario(Double.parseDouble(s[4].toString()));
            return detailsordersResponse;
        }).collect(Collectors.toList());
        return detailsordersList;
    }
}

