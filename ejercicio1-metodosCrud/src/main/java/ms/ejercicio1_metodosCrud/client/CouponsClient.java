package ms.ejercicio1_metodosCrud.client;

import ms.ejercicio1_metodosCrud.model.Coupons;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "coupons", url = "https://6331c39d3ea4956cfb66c90d.mockapi.io/persons/")
public interface CouponsClient {

    @GetMapping("/coupons")
    public List<Coupons> leerCoupons();
}
