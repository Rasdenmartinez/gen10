package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.customerAndEmployeeResponse.EmployeeDTO;
import ms.tienda.entity.Empleados;
import ms.tienda.repository.EmpleadosRepository;
import ms.tienda.service.IClienteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {

    @InjectMocks
    EmpleadoService empleadoService;

    @Mock
    EmpleadosRepository empleadosRepository;

    Empleados empleado, empleadoC, empleadoU;
    List<Empleados> empleadosList;


    @BeforeEach
    void setUp() {
        log.info("Ejecutando BeforeEach");
        empleadosList=new ArrayList<>();
        empleado=new Empleados(
          1l, "Andrea", "Torres", "Tecnico A", 85000.5, "2023/05/12"
        );
        empleadoC=new Empleados(
                2l, "Casandra", "Ramirez", "Tecnico B", 75000.5, "2023/05/12"
        );
        empleadoU=new Empleados(
                3l, "Maria", "Torres", "Tecnico C", 60000.5, "2023/05/12"
        );
        empleadosList.add(empleado);
        empleadosList.add(empleadoC);
        empleadosList.add(empleadoU);
    }

    @AfterEach
    void tearDown() {
        log.info("Ejecutando AfterEach");
    }

    @Test
    void readById() {
        log.info("Ejecutando readById");
        Mockito.when(empleadosRepository.findById(1L)).thenReturn(Optional.of(empleado));
        Optional<Empleados> empleadoResponse=empleadoService.readById(1L);
        Assertions.assertEquals(empleado, empleadoResponse.get());
    }

    @Test
    void readAll() {
        log.info("Ejecutando readAll");
        Mockito.when(empleadosRepository.findAll()).thenReturn(empleadosList);
        List<Empleados> empleadoResponse=empleadoService.readAll();
        Assertions.assertEquals(empleadosList, empleadoResponse);
    }

    @Test
    void create() {
        log.info("Ejecutando create");
        Mockito.when(empleadosRepository.save(empleado)).thenReturn(empleado);
        Empleados empleadoCreate=empleadoService.create(empleado);
        Assertions.assertEquals(empleadoCreate, empleado);
    }

    @Test
    void update() {
        log.info("Ejecutando update");
        Mockito.when(empleadosRepository.save(empleadoU)).thenReturn(empleadoU);
        Empleados empleadoResponse=empleadoService.update(empleadoU);
        Assertions.assertEquals(empleadoResponse, empleadoU);
    }

    @Test
    void delete() {
        log.info("Ejecutando delete");
        Mockito.when(empleadosRepository.findById(2L)).thenReturn(Optional.ofNullable(empleadoC));
        String messageResponse=empleadoService.delete(empleadoC);
        Assertions.assertEquals("Empleado 2, borrado correctamente", messageResponse);
    }

    @Test
    void deleteCatch(){
        Mockito.when(empleadosRepository.findById(2L)).thenReturn(Optional.ofNullable(empleadoC));
        Mockito.doThrow(new RuntimeException("Test Exception")).when(
                empleadosRepository).delete(empleadoC);
        String messageResponse=empleadoService.delete(empleadoC);
        Assertions.assertEquals("Ocurrio un error con la base de datos", messageResponse);

    }

    @Test
    void deleteElse(){
        Mockito.when(empleadosRepository.findById(2L)).thenReturn(Optional.ofNullable(null));
        String messageResponse=empleadoService.delete(empleadoC);
        Assertions.assertEquals("Empleado 2, no se encontro", messageResponse);
    }

    @Test
    void findNombre() {
        log.info("Ejecutando findNombre");
        String name="Andrea";
        Mockito.when(empleadosRepository.findByNombre(name)).thenReturn(empleadosList);
        List<Empleados> empleadoResponse=empleadoService.findNombre(name);
        Assertions.assertEquals(empleadosList, empleadoResponse);
    }

    @Test
    void responseQuery() {
        log.info("Ejecutando responseQuery");
        String name = "Sandra";
        Object[] dataObject = {"Sandra", "Supervisora", "2023-02-10"};
        List<Object[]> objectsData= Arrays.asList(new Object[][]{dataObject});

        Mockito.when(empleadosRepository.employeeResponse(name)).thenReturn(objectsData);
        List<EmployeeDTO> employeeResponse=empleadoService.responseQuery(name);
        assertEquals(1, employeeResponse.size());
        assertEquals("Sandra", employeeResponse.get(0).getNombre());
        assertEquals("Supervisora", employeeResponse.get(0).getPuesto());
        assertEquals("2023-02-10", employeeResponse.get(0).getFechaContratacion());
    }
}