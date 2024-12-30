package com.desarrolladora.leydy.Barberia.service.impl;

import com.desarrolladora.leydy.Barberia.Repository.OrdersRepository;
import com.desarrolladora.leydy.Barberia.entity.Orders;
import com.desarrolladora.leydy.Barberia.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
//las compras se hacen para el dia, filtra orders despues de la fecha de inicia y antes de  hoy
@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> getOrders(String appointmentDate) {
        LocalDate date = LocalDate.parse(appointmentDate);
        LocalDate startDate = LocalDate.parse("2024-01-02");
        LocalDate now =LocalDate.now();
        if(date.isAfter(now)){
            new IllegalArgumentException("la fecha no puede ser posterior a hoy");
        }
        if(date.isBefore(startDate)){
            new IllegalArgumentException("la fecha no puede ser antes de la feha de inicio de procesos");
        }
        return ordersRepository.findByAppointmentDate(date);

    }
}
