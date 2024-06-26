package ms.ejercicio1_metodosCrud.controller;

import jakarta.websocket.server.PathParam;
import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @GetMapping("/persona")
    public List<Persona> readAll(){
        return personaService.readAll();
    }
    @GetMapping("/persona/nombre")
    public List<Persona> findName(@PathParam("name") String name){
        return personaService.findName(name);
    }
    @GetMapping("/persona/mayoredad")
    public List<Persona> findEdad(@PathParam("edad") Byte edad){
        return personaService.findEdad(edad);
    }
    @PostMapping("/persona")
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


