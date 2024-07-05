package ms.tienda.controller;

import ms.tienda.entity.Producto;
import ms.tienda.response.ProductoResponse;
import ms.tienda.response.Response;
import ms.tienda.service.impl.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void readById() {
        Long id = 1L;
        Producto producto = new Producto();
        producto.setId(id);

        when(productoService.readById(id)).thenReturn(Optional.of(producto));

        ResponseEntity<Response> responseEntity = productoController.readById(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.readById(id)).thenReturn(Optional.empty());

        responseEntity = productoController.readById(id);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No encontrado", responseEntity.getBody().getMessage());
    }

    @Test
    void readByIdResponse() {
        Long id = 1L;
        String nombre = "Producto A";
        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setNombre(nombre);

        when(productoService.readByIdResponse(id)).thenReturn(Optional.of(productoResponse));

        ResponseEntity<Response> responseEntity = productoController.readByIdResponse(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.readByIdResponse(id)).thenReturn(Optional.empty());

        responseEntity = productoController.readByIdResponse(id);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No encontrado", responseEntity.getBody().getMessage());
    }

    @Test
    void readAll() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());

        when(productoService.readAll()).thenReturn(productos);

        ResponseEntity<Response> responseEntity = productoController.readAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.readAll()).thenReturn(new ArrayList<>());

        responseEntity = productoController.readAll();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No se encontraron productos", responseEntity.getBody().getMessage());
    }

    @Test
    void readAllResponse() {
        List<ProductoResponse> productosResponse = new ArrayList<>();
        productosResponse.add(new ProductoResponse());

        when(productoService.readAllResponse()).thenReturn(productosResponse);

        ResponseEntity<Response> responseEntity = productoController.readAllResponse();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.readAllResponse()).thenReturn(new ArrayList<>());

        responseEntity = productoController.readAllResponse();
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No se encontraron productos", responseEntity.getBody().getMessage());
    }

    @Test
    void findNombre() {
        String nombre = "Test";
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());

        when(productoService.findNombre(nombre)).thenReturn(productos);

        ResponseEntity<Response> responseEntity = productoController.findNombre(nombre);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.findNombre(nombre)).thenReturn(new ArrayList<>());

        responseEntity = productoController.findNombre(nombre);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No se encontraron productos con el nombre proporcionado", responseEntity.getBody().getMessage());
    }

    @Test
    void findNombreResponse() {
        String nombre = "Test";
        List<ProductoResponse> productosResponse = new ArrayList<>();
        productosResponse.add(new ProductoResponse());

        when(productoService.findNombreResponse(nombre)).thenReturn(productosResponse);

        ResponseEntity<Response> responseEntity = productoController.findNombreResponse(nombre);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.findNombreResponse(nombre)).thenReturn(new ArrayList<>());

        responseEntity = productoController.findNombreResponse(nombre);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No se encontraron productos con el nombre proporcionado", responseEntity.getBody().getMessage());
    }

    @Test
    void create() {
        Producto producto = new Producto();

        when(productoService.create(producto)).thenReturn(producto);

        ResponseEntity<Response> responseEntity = productoController.create(producto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Producto creado con éxito", responseEntity.getBody().getMessage());

        doThrow(new RuntimeException()).when(productoService).create(producto);

        responseEntity = productoController.create(producto);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Error al crear el producto", responseEntity.getBody().getMessage());
    }

    @Test
    void update() {
        Producto producto = new Producto();
        producto.setId(1L);

        when(productoService.readById(producto.getId())).thenReturn(Optional.of(producto));
        when(productoService.update(producto)).thenReturn(producto);

        ResponseEntity<Response> responseEntity = productoController.update(producto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Producto actualizado con éxito", responseEntity.getBody().getMessage());

        when(productoService.readById(producto.getId())).thenReturn(Optional.empty());

        responseEntity = productoController.update(producto);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Producto no encontrado", responseEntity.getBody().getMessage());
    }

    @Test
    void delete() {
        Producto producto = new Producto();
        producto.setId(1L);

        when(productoService.readById(producto.getId())).thenReturn(Optional.of(producto));
        when(productoService.delete(producto)).thenReturn("Producto eliminado con éxito");

        ResponseEntity<Response> responseEntity = productoController.delete(producto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Producto eliminado con éxito", responseEntity.getBody().getMessage());

        when(productoService.readById(producto.getId())).thenReturn(Optional.empty());

        responseEntity = productoController.delete(producto);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Producto no encontrado", responseEntity.getBody().getMessage());
    }

    @Test
    void findByProveedorIdResponse() {
        Long id = 1L;
        List<ProductoResponse> productosResponse = new ArrayList<>();
        productosResponse.add(new ProductoResponse());

        when(productoService.findProductosByProveedorId(id)).thenReturn(productosResponse);

        ResponseEntity<Response> responseEntity = productoController.findByProveedorIdResponse(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Éxito", responseEntity.getBody().getMessage());

        when(productoService.findProductosByProveedorId(id)).thenReturn(new ArrayList<>());

        responseEntity = productoController.findByProveedorIdResponse(id);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("No se encontraron productos", responseEntity.getBody().getMessage());
    }
}
