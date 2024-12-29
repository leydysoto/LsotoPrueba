package com.desarrolladora.leydy.Barberia.service;

import com.desarrolladora.leydy.Barberia.entity.Shopping;
import com.desarrolladora.leydy.Barberia.model.request.ShoppingRequest;

import java.util.List;

public interface ShoppingService {

    String createShopping(ShoppingRequest shoppingRequest);
    Shopping getShopping(Long shoppingId);
    List<Shopping> getAllShopping();
    void deleteShopping(Long shoppingId);

}
