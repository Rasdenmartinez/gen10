package ms.ejercicio1_metodosCrud.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.repository.PersonaRepository;
import ms.ejercicio1_metodosCrud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Optional<Persona> readById(long id) { return personaRepository.findById(id); }
    @Override
    public List<Persona> readAll() { return personaRepository.findAll().stream().filter(s->s.getIsActive()).toList(); }
    @Override
    public Persona create(Persona persona) { return personaRepository.save(persona); }
    @Override
    public Persona update(Persona persona) { return personaRepository.save(persona); }
    @Override
    public String delete(Persona persona) {
        Optional<Persona> personaOpt=personaRepository.findById(persona.getId());
        if (personaOpt.isPresent()){
            Persona personaBase=personaOpt.get();
            personaBase.setIsActive(false);
            try{
                personaRepository.save(personaBase);
                return "Persona "+personaBase.getId()+" borrado correctamente";
            }catch(Exception ex){
                log.error("Error "+ex.getMessage());
                log.error("Rastreo "+ex.getStackTrace());
                return "Ocurrio un error con la base de datos";
            }

        }else{
            return "Persona "+persona.getId()+" no se encontró";

        }


    }
}
