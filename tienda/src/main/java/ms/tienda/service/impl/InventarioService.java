package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Inventario;
import ms.tienda.mapper.InventarioMapper;
import ms.tienda.repository.InventarioRepository;
import ms.tienda.response.InventarioResponse;
import ms.tienda.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InventarioService implements IInventarioService {
    @Autowired
    InventarioRepository inventarioRepository;

    @Autowired
    private InventarioMapper inventarioMapper;

    @Override
    public Optional<Inventario> readByIdProducto(Long id) {
        return inventarioRepository.findByProducto_Id(id);
    }

    @Override
    public Optional<InventarioResponse> readByIdProductoResponse(Long id) {
        Optional<Inventario> inventarioOpt = inventarioRepository.findByProducto_Id(id);
        return inventarioOpt.map(inventarioMapper::toInventarioResponse);
    }

    @Override
    public List<Inventario> readAll() {
        return inventarioRepository.findAll().stream().filter(s -> s.getIsActive()).toList();
    }

    @Override
    public List<InventarioResponse> readAllResponse() {
        List<Inventario> pedidos = inventarioRepository.findAll().stream().filter(s->s.getIsActive()).toList();
        return inventarioMapper.toInventarioResponseList(pedidos);
    }

    @Override
    public List<Inventario> findIsActive(Boolean isActive) {
        return inventarioRepository.findByIsActiveEquals(isActive);
    }

    @Override
    public List<InventarioResponse> findIsActiveResponse(Boolean isActive) {
        List<Inventario> inventarios = inventarioRepository.findByIsActiveEquals(isActive);
        return inventarioMapper.toInventarioResponseList(inventarios);
    }

    @Override
    public Inventario create(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario update(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public String delete(Inventario inventario) {
        if(inventario.equals(inventarioRepository.findByProducto_Id(inventario.getProducto().getId()).orElse(null))){
            inventario.setIsActive(false);
            inventarioRepository.save(inventario);
            return "Inventario eliminado";
        } else
            return "Inventario no encontrado";
    }

    @Override
    public List<InventarioResponse> findByIsActiveTrue() {
        List<Inventario> inventarios = inventarioRepository.findByIsActiveTrue();
        return inventarioMapper.toInventarioResponseList(inventarios);
    }
}
