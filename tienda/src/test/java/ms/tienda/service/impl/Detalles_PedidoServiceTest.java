package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.details_orders.DetailsOrdersDTO;
import ms.tienda.entity.Detalles_Pedido;
import ms.tienda.repository.Detalles_PedidoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class Detalles_PedidoServiceTest {

    @InjectMocks
    private Detalles_PedidoService detallesPedidoService;

    @Mock
    private Detalles_PedidoRepository detallesPedidoRepository;

    private Detalles_Pedido detallesPedido;
    private Long id;

    @BeforeEach
    void setUp() {
        id = 1L;
        detallesPedido = new Detalles_Pedido();
        detallesPedido.setId(id);
        detallesPedido.setCantidad(String.valueOf(10));
    }

    @AfterEach
    void tearDown() {
        log.info("Ejecutando after");
    }

    @Test
    void readById() {
        Long id = 1L;
        Detalles_Pedido detallesPedido = new Detalles_Pedido();
        detallesPedido.setId(id);

        when(detallesPedidoRepository.findById(id)).thenReturn(Optional.of(detallesPedido));

        Optional<Detalles_Pedido> result = detallesPedidoService.readById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    void readAll() {
        List<Detalles_Pedido> detallesPedidoList = Arrays.asList(new Detalles_Pedido(), new Detalles_Pedido());

        when(detallesPedidoRepository.findAll()).thenReturn(detallesPedidoList);

        List<Detalles_Pedido> result = detallesPedidoService.readAll();

        assertEquals(2, result.size());
    }

    @Test
    void create() {
        Detalles_Pedido detallesPedido = new Detalles_Pedido();

        when(detallesPedidoRepository.save(detallesPedido)).thenReturn(detallesPedido);

        Detalles_Pedido result = detallesPedidoService.create(detallesPedido);

        assertNotNull(result);
    }

    @Test
    void update() {
        Detalles_Pedido detallesPedido = new Detalles_Pedido();

        when(detallesPedidoRepository.save(detallesPedido)).thenReturn(detallesPedido);

        Detalles_Pedido result = detallesPedidoService.update(detallesPedido);

        assertNotNull(result);
    }

    @Test
    void delete() {
        Long id = 1L;
        Detalles_Pedido detallesPedido = new Detalles_Pedido();
        detallesPedido.setId(id);

        when(detallesPedidoRepository.findById(id)).thenReturn(Optional.of(detallesPedido));
        doNothing().when(detallesPedidoRepository).deleteById(id);

        String result = detallesPedidoService.delete(detallesPedido);

        assertEquals("Detalles del pedido " + id + ", borrado correctamente", result);
    }

    @Test
    void deleteCatch() {
        Long id = 1L;
        Detalles_Pedido detallesPedido = new Detalles_Pedido();
        detallesPedido.setId(id);

        when(detallesPedidoRepository.findById(id)).thenReturn(Optional.of(detallesPedido));
        doThrow(new RuntimeException("Database error")).when(detallesPedidoRepository).deleteById(id);

        String result = detallesPedidoService.delete(detallesPedido);

        assertEquals("Ocurrió un error con la base de datos", result);
        verify(detallesPedidoRepository, times(1)).findById(id);
        verify(detallesPedidoRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteElse() {
        Long id = 1L;
        Detalles_Pedido detallesPedido = new Detalles_Pedido();
        detallesPedido.setId(id);

        when(detallesPedidoRepository.findById(id)).thenReturn(Optional.empty());

        String result = detallesPedidoService.delete(detallesPedido);

        assertEquals("Detalles del pedido " + id + " no se encontraron", result);
        verify(detallesPedidoRepository, times(1)).findById(id);
        verify(detallesPedidoRepository, never()).deleteById(any(Long.class));
    }

    @Test
    void response() {
        String id = "TestNombre";
        List<Object[]> objectList = Arrays.asList(
                new Object[]{1L, "2024-07-12", "Producto1", 10, 100.0},
                new Object[]{2L, "2024-07-13", "Producto2", 20, 200.0}
        );

        when(detallesPedidoRepository.detailsordersResponse(id)).thenReturn(objectList);

        List<DetailsOrdersDTO> result = detallesPedidoService.response(id);

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(LocalDate.parse("2024-07-12"), result.get(0).getFechaDelPedido());
        assertEquals("Producto1", result.get(0).getDescripcionProducto());
        assertEquals(10, result.get(0).getCantidad());
        assertEquals(100.0, result.get(0).getPrecioUnitario(), 0.0);
    }
}
