package ms.tienda.service;

import ms.tienda.entity.Inventario;
import ms.tienda.response.InventarioResponse;
import java.util.List;
import java.util.Optional;

public interface IInventarioService {

    public Optional<Inventario> readById(Long id);
    public Optional<InventarioResponse> readByIdResponse(Long id);
    public List<Inventario> readAll();
    public List<InventarioResponse> readAllResponse();
    public List<Inventario> findIsActive(Boolean isActive);
    public List<InventarioResponse> findIsActiveResponse(Boolean isActive);
    public Inventario create(Inventario inventario);
    public Inventario update(Inventario inventario);
    public String delete(Inventario inventario);
    public List<InventarioResponse> findByIsActiveTrue();

}
