package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.customerAndEmployeeResponse.EmployeeDTO;
import ms.tienda.entity.Empleados;
import ms.tienda.repository.EmpleadosRepository;
import ms.tienda.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    EmpleadosRepository empleadosRepository;

    @Override
    public Optional<Empleados> readById(Long idEmpleado) {
        return empleadosRepository.findById(idEmpleado);
    }

    @Override
    public List<Empleados> readAll() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleados create(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public Empleados update(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public String delete(Empleados empleado) {
            Optional<Empleados> empleadoOpt =empleadosRepository.findById(empleado.getIdEmpleado());
            if (empleadoOpt.isPresent()){
                Empleados empleadoDelete = empleadoOpt.get();
                try{
                    empleadosRepository.delete(empleadoDelete); //usar anotacion save, pero no me elimina de la BD
                    return "Empleado"+ empleadoDelete.getIdEmpleado()+", borrado correctamente";
                }catch(Exception ex){
                    log.error("Error "+ex.getMessage());
                    log.error("Rastreo "+ex.getStackTrace());
                    return "Ocurrio un error con la base de datos";
                }

            }else{
                return "Empleado "+empleado.getIdEmpleado()+" no se encontró";
            }
    }

    @Override
    public List<Empleados> findNombre(String nombre) {
        return empleadosRepository.findByNombre(nombre);
    }

    @Override
    public List<EmployeeDTO> responseQuery(String nombre) {
        List<Object[]> objectList=empleadosRepository.employeeResponse(nombre);
        List<EmployeeDTO> employeeResponseList =objectList.stream().map(s->{
            EmployeeDTO employeeResponse =new EmployeeDTO();
            employeeResponse.setNombre(s[0].toString());
            employeeResponse.setPuesto(s[1].toString());
            employeeResponse.setFechaContratacion(s[2].toString());
            return employeeResponse;
        }).toList();
        return employeeResponseList;
    }
}

