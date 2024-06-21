package ms.tienda.controller;

import ms.tienda.entity.Empleados;
import ms.tienda.service.impl.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
    @GetMapping("/empleados/{idEmpleado}")
    public Optional<Empleados> readById(@PathVariable Long idEmpleado){
        return empleadoService.readById(idEmpleado);
    }

}
