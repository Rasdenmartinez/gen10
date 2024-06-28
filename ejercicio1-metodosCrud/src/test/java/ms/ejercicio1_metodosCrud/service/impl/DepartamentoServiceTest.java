package ms.ejercicio1_metodosCrud.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {
    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;

    List<Departamento> departamentoList;

    Departamento departamentoTest;
    Departamento departamentoEmpty;

    @BeforeEach
    void setUp() {

        departamentoList=new ArrayList<>();
        departamentoTest=new Departamento(1L,100.00,50000.00,true);
        departamentoEmpty=new Departamento();
        departamentoList.add(departamentoTest);
        log.info("Ejecutando Before");
    }

    @AfterEach
    void tearDown() {
        log.info("Ejecutando after");
    }

    @Test
    void readById() {
        log.info("ejecutando reabById");
        Departamento departamento=new Departamento(1L,100.00,800000.00,true);
        Departamento departamentoExpected=new Departamento(1L,200.00,800000.00,true);

        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.of(departamento));
        Optional<Departamento> departamentoOptional=departamentoService.readById(1L);
        Assertions.assertEquals(departamentoExpected, departamentoOptional.get());

    }

    @Test
    void readAll() {
        log.info("Ejecutando readAll");

        Mockito.when(departamentoRepository.findAll()).thenReturn(departamentoList);
        List<Departamento> departamentosResponse=departamentoService.readAll();
        Assertions.assertEquals(departamentoList,departamentosResponse);
    }
//
//    @Test
//    void create() {
//    }
//
//    @Test
//    void update() {
//    }
//
    @Test
    void delete() {
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(departamentoTest));
        Mockito.when(departamentoRepository.save(departamentoTest)).thenReturn(departamentoTest);
        String messageResponse=departamentoService.delete(departamentoTest);
        Assertions.assertEquals("Departamento 1 borrado correctamente",messageResponse);
    }

    @Test
    void deleteCatch(){
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(departamentoEmpty));
        Mockito.when(departamentoRepository.save(departamentoTest)).thenReturn(departamentoTest);
        String messageResponse=departamentoService.delete(departamentoTest);
        Assertions.assertEquals("Ocurrio un error con la base de datos",messageResponse);
    }

    @Test
    void deleteElse(){
        Mockito.when(departamentoRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
//        Mockito.when(departamentoRepository.save(departamentoTest)).thenReturn(departamentoTest);
        String messageResponse=departamentoService.delete(departamentoTest);
        Assertions.assertEquals("Departamento 1 no se encontro",messageResponse);
    }
}