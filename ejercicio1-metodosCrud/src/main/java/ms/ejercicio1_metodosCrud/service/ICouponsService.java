package ms.ejercicio1_metodosCrud.service;

import ms.ejercicio1_metodosCrud.model.Coupons;

import java.util.List;
import java.util.Optional;

public interface ICouponsService {
    public Optional<Coupons> readById(Long id);
    List<Coupons> readAll();
    public Coupons create(Coupons coupons);
    public Coupons update(Coupons coupons);
    public Coupons deleteById(Long id);
}
