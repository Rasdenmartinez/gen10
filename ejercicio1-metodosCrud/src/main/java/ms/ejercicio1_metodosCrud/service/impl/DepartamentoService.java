package ms.ejercicio1_metodosCrud.service.impl;

import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.repository.DepartamentoRepository;
import ms.ejercicio1_metodosCrud.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;


    @Override
    public Optional<Departamento> readById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento create(Departamento deparmento) {
        return departamentoRepository.save(deparmento);
    }

    @Override
    public Departamento update(Departamento deparmento) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
