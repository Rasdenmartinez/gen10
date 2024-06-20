package ms.ejercicio1_metodosCrud.service.impl;

import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.repository.PersonaRepository;
import ms.ejercicio1_metodosCrud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;


    @Override
    public Optional<Persona> readById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> readAll() { return personaRepository.findAll();}

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
