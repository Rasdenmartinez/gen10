package ms.tienda.service;

import ms.tienda.entity.Empleados;
import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    public Optional<Empleados> readById(Long idEmpleado);
    public List<Empleados> readAll();
    public Empleados create(Empleados empleado);
    public Empleados update(Empleados empleado);
    public void delete(Long idEmpleado);
}
