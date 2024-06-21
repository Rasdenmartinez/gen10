package ms.ejercicio1_metodosCrud.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_metodosCrud.entity.Departamento;
import ms.ejercicio1_metodosCrud.repository.DepartamentoRepository;
import ms.ejercicio1_metodosCrud.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;


    @Override
    public Optional<Departamento> readById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll().stream().filter(s->s.getIsActive()).toList();
    }

    @Override
    public Departamento create(Departamento deparmento) {
        return departamentoRepository.save(deparmento);
    }

    @Override
    public Departamento update(Departamento deparmento) {
        return departamentoRepository.save(deparmento);
    }

    @Override
    public String delete(Departamento departamento) {
        Optional<Departamento> departamentoOpt=departamentoRepository.findById(departamento.getId());
        if (departamentoOpt.isPresent()){
            Departamento departamentoBase=departamentoOpt.get();
            departamentoBase.setIsActive(false);
            try{
                departamentoRepository.save(departamentoBase);
                return "Departamento "+departamentoBase.getId()+" borrado correctamente";
            }catch(Exception ex){
                log.error("Error "+ex.getMessage());
                log.error("Rastreo "+ex.getStackTrace());
                return "Ocurrio un error con la base de datos";
            }

        }else{
            return "Departamento "+departamento.getId()+" no se encontró";

        }


    }
}
