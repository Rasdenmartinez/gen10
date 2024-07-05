package ms.tienda.service;

import ms.tienda.customerAndEmployeeResponse.CustomerDTO;
import ms.tienda.entity.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public Optional<Clientes> readById(Long Id);
    public List<Clientes> readAll();
    public Clientes create(Clientes cliente); //crear
    public Clientes update(Clientes cliente); //actualizar
    public String delete(Clientes cliente);
//Parametros de response
    List<Clientes> findName(String nombre);
    List<CustomerDTO> responseQuery(String nombre);

}
