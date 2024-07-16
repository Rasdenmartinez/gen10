package ms.tienda.service;

import ms.tienda.model.Ciber;

import java.util.List;
import java.util.Optional;

public interface ICiberService {
    public Optional<Ciber> readById(Long id);
    List<Ciber> readAll();
    public Ciber create(Ciber ciber);
    public Ciber update(Ciber ciber);
    public Ciber deleteById(Long id);
}
