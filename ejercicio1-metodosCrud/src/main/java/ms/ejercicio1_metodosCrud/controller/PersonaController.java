package ms.ejercicio1_metodosCrud.controller;

import jakarta.websocket.server.PathParam;
import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.response.PersonaResponse;
import ms.ejercicio1_metodosCrud.response.Response;
import ms.ejercicio1_metodosCrud.service.impl.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

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
    @PostMapping("/persona/create")
    public Persona create(@RequestBody Persona persona){
        return personaService.create(persona);
    }

    @PutMapping("/persona/update")
    public Persona update(@RequestBody Persona persona){
        return personaService.update(persona);
    }

    @DeleteMapping("/persona/delete")
    public String delete(@RequestBody Persona persona){
        return personaService.delete(persona);
    }

    @GetMapping("/personaResponse")
    public ResponseEntity<List<PersonaResponse>> response(@PathParam("name") String name){
        EntityResponse<List<PersonaResponse>> personResponseListEntity;
        List<PersonaResponse> personaResponseList=personaService.response(name);
        if(personaResponseList.size()>=1){
            return new ResponseEntity<>(personaResponseList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/personaResponseQuery")
    public ResponseEntity<Response> responseQuery(@PathParam("name") String name){

        EntityResponse<List<PersonaResponse>> personResponseListEntity;
        List<PersonaResponse> personaResponseList=personaService.responseQuery(name);
        if(personaResponseList.size()>=1){
            Response response=Response.builder()
                    .message("Success")
                    .code("0")
                    .personaResponseList(personaResponseList).build();

            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            Response response=Response.builder()
                    .message("Not found, verify your parameters")
                    .code("1005")
                    .personaResponseList(personaResponseList).build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}