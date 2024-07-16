package ms.tienda.service;

import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.customerAndEmployeeResponse.EmployeeDTO;
import ms.tienda.entity.Empleados;
import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    public Optional<Empleados> readById(Long idEmpleado);
    public List<Empleados> readAll();
    public Empleados create(Empleados empleado);
    public Empleados update(Empleados empleado);
    public String delete(Empleados empleado);

    //parametrizados
    List<Empleados> findNombre(String nombre);
    List<EmployeeDTO> responseQuery(String nombre);

}
