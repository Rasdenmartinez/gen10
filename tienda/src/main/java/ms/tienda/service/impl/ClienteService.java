package ms.tienda.service.impl;

import ms.tienda.entity.Clientes;
import ms.tienda.repository.ClientesRepository;
import ms.tienda.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Optional<Clientes> readById(Long Id) {
        return clientesRepository.findById(Id);
    }

    @Override
    public Clientes create(Clientes cliente) {
        return null;
    }

    @Override
    public Clientes update(Clientes cliente) {
        return null;
    }

    @Override
    public void delete(Long Id) {
    }
}
