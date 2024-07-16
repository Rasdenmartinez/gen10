package ms.tienda.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.tienda.client.CiberClient;
import ms.tienda.model.Ciber;
import ms.tienda.service.ICiberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CiberService implements ICiberService {

    @Autowired
    CiberClient ciberClient;

    @Override
    public Optional<Ciber> readById(Long id) {
        return ciberClient.findById(id);
    }

    @Override
    public List<Ciber> readAll() {
        return ciberClient.leerCoupons();
    }

    @Override
    public Ciber create(Ciber ciber) {
        return ciberClient.create(ciber);
    }

    @Override
    public Ciber update(Ciber ciber) {
        return ciberClient.update(ciber.getId(),ciber);
    }

    @Override
    public Ciber deleteById(Long id) {
        return ciberClient.delete(id);
    }
}