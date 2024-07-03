package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.entity.Clientes;
import ms.tienda.repository.ClientesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;
    @Mock
    ClientesRepository clientesRepository;
    Clientes cliente, clienteC, clienteU;
    List<Clientes> clientesList;


    @BeforeEach
    void setUp() {
        log.info("Ejecutando BeforeEach");
        clientesList=new ArrayList<>();
        cliente=new Clientes(
            1L, "Juan", "Martinez", "Meguel Aleman", "juan@gmail.com", "9241568987");
        clientesList.add(cliente);
        clienteC=new Clientes(
                2L, "Juana", "Martinez", "Meguel Aleman", "juan@gmail.com", "9241568987");
        clientesList.add(clienteC);
        clienteU=new Clientes(
                2L, "Susana", "Martinez", "Miguel Aleman", "susana@gmail.com", "6941568987");
    }

    @AfterEach
    void tearDown() {
        log.info("Ejecutando AfterEach");
    }

    @Test
    void readById() {
        log.info("Ejecutando readById");
        Mockito.when(clientesRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Optional<Clientes> clientesOptional=clienteService.readById(1L);
        assertEquals(cliente, clientesOptional.get());
    }

    @Test
    void readAll() {
        log.info("Ejecutando readAll");
        Mockito.when(clientesRepository.findAll()).thenReturn(clientesList);
        List<Clientes> clienteResponse=clienteService.readAll();
        assertEquals(clientesList, clienteResponse);
    }

    @Test
    void create() {
        log.info("Ejecutando Create");
        Mockito.when(clientesRepository.save(clienteC)).thenReturn(clienteC);
        Clientes clienteCreate=clienteService.create(clienteC);
        assertEquals(clienteCreate, clienteC);

    }

    @Test
    void update() {
        log.info("Ejecutando Update");
        Mockito.when(clientesRepository.save(clienteU)).thenReturn(clienteU);
        Clientes clientes=clienteService.update(clienteU);
        assertEquals(clienteU, clientes);
    }

    @Test
    void delete() {
        log.info("Ejecutando Delete");
        Mockito.when(clientesRepository.findById(1L)).thenReturn(Optional.ofNullable(cliente));
        String messageResponse= clienteService.delete(cliente);
        assertEquals("Cliente 1, borrado correctamente", messageResponse);
    }

    @Test
    void deleteCatch(){
        log.info("Ejecutando DeleteCatch");
        Mockito.when(clientesRepository.findById(1L)).thenReturn(Optional.ofNullable(cliente));
        Mockito.doThrow(new RuntimeException("Test Exception"))
                .when(clientesRepository).delete(cliente);
        String messageResponse= clienteService.delete(cliente);
        assertEquals("Ocurrio un error con la base de datos", messageResponse);
    }

    @Test
    void deleteElse(){
        log.info("Ejecutando DeleteElse");
        Mockito.when(clientesRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        String messageResponse= clienteService.delete(cliente);
        assertEquals("Cliente 1 no se encontró", messageResponse);

    }

    @Test
    void findName() {
        log.info("Ejecutando findName");
        List<Clientes> clienteName = new ArrayList<>();
        String name = "Maria";
        clienteName.add(new Clientes(2L, "Juana", "Martinez", "Miguel Aleman", "juan@gmail.com", "9241568987"));
        Mockito.when(clientesRepository.findByNombre(name)).thenReturn(clienteName);
        List<Clientes> clienteResponse = clienteService.findName(name);
        assertEquals(clienteName, clienteResponse);
    }

    @Test
    void responseQuery() {
        log.info("Ejecutando responseQuery");
        String name = "Juan";
        Object[] dataObject = {"Juana", "juan@gmail.com", "9241568987"};
        List<Object[]> objectsData = Arrays.asList(new Object[][]{dataObject});

        Mockito.when(clientesRepository.customerResponse(name)).thenReturn(objectsData);
        List<CustomerDTO> customerResponse=clienteService.responseQuery(name);
        assertEquals(1, customerResponse.size());
        assertEquals("Juana", customerResponse.get(0).getNombre());
        assertEquals("juan@gmail.com", customerResponse.get(0).getMail());
        assertEquals("9241568987", customerResponse.get(0).getTelefono());
    }
}