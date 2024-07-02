package ms.ejercicio1_metodosCrud.service.impl;

import ms.ejercicio1_metodosCrud.client.CouponsClient;
import ms.ejercicio1_metodosCrud.model.Coupons;
import ms.ejercicio1_metodosCrud.service.ICouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponsService implements ICouponsService {
    @Autowired
    CouponsClient couponsClient;

//    private final CouponsClient couponsClient;
//
//    public CouponsService(CouponsClient couponsClient) {
//        this.couponsClient = couponsClient;
//    }


    @Override
    public List<Coupons> readAll() {
        return couponsClient.leerCoupons();
    }
}
