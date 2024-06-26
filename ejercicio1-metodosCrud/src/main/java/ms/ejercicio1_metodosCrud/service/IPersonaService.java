package ms.ejercicio1_metodosCrud.service;

import ms.ejercicio1_metodosCrud.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public Optional<Persona> readById(Long id);
    public List<Persona> readAll();
    public Persona create(Persona deparmento);
    public Persona update(Persona deparmento);
    public String delete(Persona persona);

    public List<Persona> findName(String name);

    List<Persona> findEdad(Byte edad);
}
