package ms.tienda.service.impl;

import ms.tienda.entity.Empleados;
import ms.tienda.repository.EmpleadosRepository;
import ms.tienda.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        return List.of();
    }

    @Override
    public Empleados create(Empleados empleado) {
        return null;
    }

    @Override
    public Empleados update(Empleados empleado) {
        return null;
    }

    @Override
    public void delete(Long idEmpleado) {
    }
}
