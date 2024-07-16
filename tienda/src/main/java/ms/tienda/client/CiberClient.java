package ms.tienda.client;

import ms.tienda.model.Ciber;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "cibersClient", url = "https://668373a04102471fa4ca1c5e.mockapi.io")

    public interface CiberClient {

    @GetMapping("/ciber")
    List<Ciber> leerCoupons();
    @GetMapping("/ciber/{id}")
    Optional<Ciber> findById(@PathVariable Long id);
    @PostMapping("/ciber")
    Ciber create(@RequestBody Ciber ciber);
    @PutMapping("/ciber/{id}")
    Ciber update(@PathVariable("id") Long id, @RequestBody Ciber ciber);
    @DeleteMapping("/ciber/{id}")
    Ciber delete(@PathVariable("id") Long id);
}