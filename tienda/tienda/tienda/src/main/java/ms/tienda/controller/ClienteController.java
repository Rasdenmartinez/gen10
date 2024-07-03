package ms.tienda.controller;

import ms.tienda.entity.Clientes;
import ms.tienda.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
