package ms.tienda.controller;

import ms.tienda.model.Ciber;
import ms.tienda.service.impl.CiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CiberController {


    @Autowired
    CiberService ciberService;

    @GetMapping("/consumoApiTercero")
    List<Ciber> consumoApiTercero() {
        return ciberService.readAll();
    }
    @GetMapping("/consumoApiTercero/{id}")
    public Optional<Ciber> readById(@PathVariable Long id){
        return ciberService.readById(id);
    }
    @PostMapping("/consumoApiTercero")
    public Ciber create(@RequestBody Ciber ciber){
        return ciberService.create(ciber);
    }
    @PutMapping("/consumoApiTercero/{id}")
    public Ciber update(@PathVariable long id, @RequestBody Ciber ciber){
        ciber.setId(id);
        return ciberService.update(ciber);
    }
    @DeleteMapping("/consumoApiTercero/{id}")
    public Ciber delete(@PathVariable long id){
        return ciberService.deleteById(id);
    }
}