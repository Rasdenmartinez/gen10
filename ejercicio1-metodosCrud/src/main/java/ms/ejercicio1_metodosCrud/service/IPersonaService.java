package ms.ejercicio1_metodosCrud.service;

import ms.ejercicio1_metodosCrud.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public Optional<Persona> readById(long id);
    public List<Persona> readAll();
    public Persona create(Persona persona);
    public Persona update(Persona persona);
    public String delete(Persona persona);
}
