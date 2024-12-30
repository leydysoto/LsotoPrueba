package com.desarrolladora.leydy.Barberia.service;

import com.desarrolladora.leydy.Barberia.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> getOrders(String date);
}
