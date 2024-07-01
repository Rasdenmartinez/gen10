package ms.tienda.service;

import ms.tienda.entity.Clientes;
import java.util.Optional;

public interface IClienteService {
    public Optional<Clientes> readById(Long Id);
    public Clientes create(Clientes cliente); //crear
    public Clientes update(Clientes cliente); //actualizar
    public void delete(Long Id);
}
