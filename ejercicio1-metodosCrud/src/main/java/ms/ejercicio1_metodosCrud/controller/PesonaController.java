package ms.ejercicio1_metodosCrud.controller;

import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.service.impl.DepartamentoService;
import ms.ejercicio1_metodosCrud.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PesonaController {
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
    @PostMapping("/person")
    public Persona create(@RequestBody Persona persona){
        return personaService.create(persona);
    }

    @PutMapping("/persona")
    public Persona update(@RequestBody Persona persona){
        return personaService.update(persona);
    }

    @DeleteMapping("/persona")
    public String delete(@RequestBody Persona persona){
        return personaService.delete(persona);
    }

}