package ms.ejercicio1_metodosCrud.controller;

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
    private ICouponsService couponsService;

    @GetMapping("/consumoApiTercero")
    List<Coupons> consumoApiTercero() {
        return couponsService.readAll();
    }
}
