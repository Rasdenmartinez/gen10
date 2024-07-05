package ms.tienda.controller;

import jakarta.websocket.server.PathParam;
import ms.tienda.customerAndEmployeeResponse.CustomerResponse;
import ms.tienda.customerAndEmployeeResponse.EmployeeDTO;
import ms.tienda.customerAndEmployeeResponse.EmployeeResponse;
import ms.tienda.entity.Empleados;
import ms.tienda.service.impl.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/empleados/all")
    public List<Empleados> readAll(){
        return empleadoService.readAll();
    }

    @PutMapping("/empleados/create")
    public Empleados create(@RequestBody Empleados empleado){
        return empleadoService.create(empleado);
    }

    @PostMapping("/empleados/update")
    public Empleados update(@RequestBody Empleados empleado){
        return empleadoService.update(empleado);
    }

    @DeleteMapping("/empleados/delete")
    public String delete(@RequestBody  Empleados empleado){
        return empleadoService.delete(empleado);
    }

    @GetMapping("/empleados/nombre")
    public List<Empleados> findByNombre(String nombre){
        return empleadoService.findNombre(nombre);
    }

    @GetMapping("/empleados/responseQuery")
    public ResponseEntity<EmployeeResponse> responseQuery(@PathParam("nombre") String nombre) {
        List<EmployeeDTO> employeeResponseList = empleadoService.responseQuery(nombre);
        EmployeeResponse response;
        if (employeeResponseList.isEmpty()) {
            response = EmployeeResponse.builder()
                    .message("Not Found, verify your parameters")
                    .codeMessage("1005")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response = EmployeeResponse.builder()
                    .message("Succes")
                    .codeMessage("0")
                    .employeeResponseList(employeeResponseList)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
