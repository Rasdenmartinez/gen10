package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.entity.Producto;
import ms.tienda.repository.ProductoRepository;
import ms.tienda.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class ProductoService implements IProductoService {
    
    @Autowired
    ProductoRepository productoRepository;


    @Override
    public Optional<Producto> readById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> readAll() {
        return productoRepository.findAll().stream().filter(s->s.getIsActive()).toList();
    }

    @Override
    public List<Producto> findNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public String delete(Producto departamento) {
        Optional<Producto> productoOpt=productoRepository.findById(departamento.getId());
        if (productoOpt.isPresent()){
            Producto departamentoBase=productoOpt.get();
            departamentoBase.setIsActive(false);
            try{
                productoRepository.save(departamentoBase);
                return "Producto "+departamentoBase.getId()+" borrado correctamente";
            }catch(Exception ex){
                log.error("Error "+ex.getMessage());
                log.error("Rastreo "+ex.getStackTrace());
                return "Ocurrio un error con la base de datos";
            }

        }else{
            return "Producto "+departamento.getId()+" no se encontró";

        }
    }
}