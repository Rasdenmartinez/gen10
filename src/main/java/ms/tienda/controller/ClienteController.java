package ms.tienda.controller;

import jakarta.websocket.server.PathParam;
import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.customerAndEmployeeResponse.CustomerResponse;
import ms.tienda.entity.Clientes;
import ms.tienda.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/clientes/nombre")
    public List<Clientes> findByName(@PathParam("nombre") String nombre){
        return clienteService.findName(nombre);
    }

    @GetMapping("/clientes/responseQuery")
    public ResponseEntity<CustomerResponse> responseQuery(@PathParam("nombre") String nombre){
        List<CustomerDTO> customerResponseList=clienteService.responseQuery(nombre);
        CustomerResponse response;
        if(customerResponseList.isEmpty()){
            response=CustomerResponse.builder()
                    .message("Not Found, verify your parameters")
                    .codeMessage("1005")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else{
            response=CustomerResponse.builder()
                    .message("Succes")
                    .codeMessage("0")
                    .customerResponseList(customerResponseList)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


}
