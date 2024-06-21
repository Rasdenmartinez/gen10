package ms.ejercicio1_metodosCrud.service;

import ms.ejercicio1_metodosCrud.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public Optional<Departamento> readById(Long id);
    public List<Departamento> readAll();
    public Departamento create(Departamento deparmento);
    public Departamento update(Departamento deparmento);
    public String delete(Departamento departamento);
}
