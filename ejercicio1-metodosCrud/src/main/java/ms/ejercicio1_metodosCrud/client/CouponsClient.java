package ms.ejercicio1_metodosCrud.client;

import ms.ejercicio1_metodosCrud.model.Coupons;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "couponsClient", url = "https://668373a04102471fa4ca1c5e.mockapi.io")

public interface CouponsClient {

    @GetMapping("/coupons")
    List<Coupons> leerCoupons();
    @GetMapping("/coupons/{id}")
    Optional<Coupons> findById(@PathVariable Long id);
    @PostMapping("/coupons")
    Coupons create(@RequestBody Coupons coupons);
    @PutMapping("/coupons/{id}")
    Coupons update(@PathVariable("id") Long id, @RequestBody Coupons coupons);
    @DeleteMapping("/coupons/{id}")
    Coupons delete(@PathVariable("id") Long id);
}
