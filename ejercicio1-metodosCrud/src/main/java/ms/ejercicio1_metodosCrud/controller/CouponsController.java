import ms.ejercicio1_metodosCrud.model.Coupons;
import ms.ejercicio1_metodosCrud.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CouponsController {
  
    @Autowired
    CouponsService couponsService;

    @GetMapping("/consumoApiTercero")
    List<Coupons> consumoApiTercero() {
        return couponsService.readAll();
    }
    @GetMapping("/consumoApiTercero/{id}")
    public Optional<Coupons> readById(@PathVariable Long id){
        return couponsService.readById(id);
    }
    @PostMapping("/consumoApiTercero")
    public Coupons create(@RequestBody Coupons coupons){
        return couponsService.create(coupons);
    }
    @PutMapping("/consumoApiTercero/{id}")
    public Coupons update(@PathVariable long id, @RequestBody Coupons coupons){
        coupons.setId(id);
        return couponsService.update(coupons);
    }
    @DeleteMapping("/consumoApiTercero/{id}")
    public Coupons delete(@PathVariable long id){
        return couponsService.deleteById(id);
    }
}
