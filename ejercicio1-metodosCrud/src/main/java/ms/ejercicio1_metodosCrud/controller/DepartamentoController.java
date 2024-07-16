package ms.ejercicio1_metodosCrud.controller;

import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.service.impl.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/departamento/{id}")
    public Optional<Departamento> readById(@PathVariable Long id){
        return departamentoService.readById(id);
    }

    @GetMapping("/departamento")
    public List<Departamento> readAll(){
        return departamentoService.readAll();
    }
    @PostMapping("/departamento")
    public Departamento create(@RequestBody Departamento departamento){
        return departamentoService.create(departamento);
    }

    @PutMapping("/departamento")
    public Departamento update(@RequestBody Departamento departamento){
        return departamentoService.update(departamento);
    }

    @DeleteMapping("/departamento")
    public String delete(@RequestBody Departamento departamento){
         return departamentoService.delete(departamento);
    }

}


