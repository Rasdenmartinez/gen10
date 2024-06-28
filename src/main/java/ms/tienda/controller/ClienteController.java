package ms.tienda.controller;

import ms.tienda.entity.Clientes;
import ms.tienda.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/clientes/{Id}")
    public Optional<Clientes> readById(@PathVariable Long Id){
        return clienteService.readById(Id);
    }

    @GetMapping("/clientes/all")
    public List<Clientes> readAll(){
        return clienteService.readAll();
    }

    @PutMapping("/clientes/create")
    public Clientes create(@RequestBody Clientes cliente){
        return clienteService.create(cliente);
    }

    @PostMapping("/clientes/update")
    public Clientes update(@RequestBody Clientes cliente){
        return clienteService.update(cliente);
    }

    @DeleteMapping("/clientes/delete")
    public String delete(@RequestBody  Clientes cliente){
        return clienteService.delete(cliente);
    }
}
