package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.entity.Clientes;
import ms.tienda.repository.ClientesRepository;
import ms.tienda.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Optional<Clientes> readById(Long Id) {
        return clientesRepository.findById(Id);
    }

    @Override
    public List<Clientes> readAll() {
        return clientesRepository.findAll();
    }


    @Override
    public Clientes create(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public Clientes update(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public String delete(Clientes cliente) {
        Optional<Clientes> clienteOpt =clientesRepository.findById(cliente.getId());
        if (clienteOpt.isPresent()){
            Clientes clienteDelete = clienteOpt.get();
            try{
                clientesRepository.delete(clienteDelete);
                return "Cliente "+ clienteDelete.getId()+", borrado correctamente";
            }catch(Exception ex){
                log.error("Error "+ex.getMessage());
                log.error("Rastreo "+ex.getStackTrace());
                return "Ocurrio un error con la base de datos";
            }

        }else{
            return "Cliente "+cliente.getId()+" no se encontró";

        }
    }

    @Override
    public List<Clientes> findName(String nombre) {
        return clientesRepository.findByNombre(nombre);
    }

    @Override
    public List<CustomerDTO> responseQuery(String nombre) {
        List<Object[]> objectList=clientesRepository.customerResponse(nombre);
        List<CustomerDTO> customerResponseList=objectList.stream().map(s->{
            CustomerDTO customerResponse=new CustomerDTO();
            customerResponse.setNombre(s[0].toString());
            customerResponse.setMail(s[1].toString());
            customerResponse.setTelefono(s[2].toString());
            return customerResponse;
        }).toList();
        return customerResponseList;
    }

}
