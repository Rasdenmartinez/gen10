package ms.ejercicio1_metodosCrud.controller;

import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/persona/{id}")
    public Optional<Persona> readById(@PathVariable Long id){
        return personaService.readById(id);
    }
    @GetMapping("/persona/todos")
    public List<Persona> readAll(){
        return personaService.readAll();
    }
    @PostMapping("/persona")
    public Persona create(@RequestBody Persona persona) {
        return personaService.create(persona);
    }
}
