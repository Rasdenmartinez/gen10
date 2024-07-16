package ms.ejercicio1_metodosCrud.service.impl;

import lombok.extern.slf4j.Slf4j;
import ms.ejercicio1_metodosCrud.client.CouponsClient;
import ms.ejercicio1_metodosCrud.model.Coupons;
import ms.ejercicio1_metodosCrud.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CouponsService implements ICouponsService {

    @Autowired
    CouponsClient couponsClient;

    @Override
    public Optional<Coupons> readById(Long id) {
        return couponsClient.findById(id);
    }

    @Override
    public List<Coupons> readAll() {
        return couponsClient.leerCoupons();
    }

    @Override
    public Coupons create(Coupons coupons) {
        return couponsClient.create(coupons);
    }

    @Override
    public Coupons update(Coupons coupons) {
        return couponsClient.update(coupons.getId(),coupons);
    }

    @Override
    public Coupons deleteById(Long id) {
        return couponsClient.delete(id);
    }

}
