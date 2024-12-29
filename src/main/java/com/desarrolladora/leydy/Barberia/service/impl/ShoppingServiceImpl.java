package com.desarrolladora.leydy.Barberia.service.impl;

import com.desarrolladora.leydy.Barberia.Repository.BarberRepository;
import com.desarrolladora.leydy.Barberia.Repository.ClientRepository;
import com.desarrolladora.leydy.Barberia.Repository.ProductRepository;
import com.desarrolladora.leydy.Barberia.Repository.ShoppingRepository;
import com.desarrolladora.leydy.Barberia.entity.*;
import com.desarrolladora.leydy.Barberia.model.request.OrdersRequest;
import com.desarrolladora.leydy.Barberia.model.request.ShoppingRequest;
import com.desarrolladora.leydy.Barberia.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    private ProductRepository productRepository;
    private ClientRepository clientRepository;
    private BarberRepository barberRepository;
    private ShoppingRepository shoppingRepository;


    @Override
    public String createShopping(ShoppingRequest shoppingRequest) {
        Shopping shopping = new Shopping();
        shopping.setClientEmail(shoppingRequest.getClientEmail());
        Integer totalQuantity= 0;
        Double totalAmount=0.0;
        Integer totalDuration=0;
        List<Orders> orders = new ArrayList<>();

        for(OrdersRequest ordersRequest : shoppingRequest.getOrders()){
            Orders order=new Orders();
            order.setAppointmentDate(LocalDate.parse(ordersRequest.getAppointmentDate()));
            order.setAppointmentTime(LocalTime.parse(ordersRequest.getAppointmentTime()));
            Product product=productRepository.findById(ordersRequest.getProductId()).orElseThrow(()->new IllegalArgumentException("producto no encontrado"+ ordersRequest.getProductId()));
            order.setProduct(product);
            Client client = clientRepository.findByEmail(ordersRequest.getClientEmail()).orElseThrow(()->new IllegalArgumentException("cliente no encontrado"+ ordersRequest.getClientEmail()));
            order.setClient(client);
            Barber barber =barberRepository.findByEmail(ordersRequest.getBarberEmail()).orElseThrow(()->new IllegalArgumentException("barber no encontrado"+ ordersRequest.getBarberEmail()));
            order.setBarber(barber);
            order.setShopping(shopping);

            //------------------cantidad del producto solicitado
            Integer quantity =ordersRequest.getQuantity();
            order.setQuantity(quantity);
            totalQuantity += quantity;
            //---------- obtener precio base  y descuento por producto
            Integer discount =product.getDiscount();
            Double price = product.getPrice();
            //--------------Calcular el precio neto
            Double discountAmount  = (price * discount/100);
            Double netPrice=price-discountAmount;
            //----------- Calcular el total
            totalAmount+= netPrice * quantity;
            order.setAmount(netPrice * quantity);
            orders.add(order);
            //----------duracion del producto-----------//
            totalDuration += product.getDuration();
        }
        //----------duracion del producto a horas-----------//
        int horas = totalDuration / 60;
        int min = totalDuration % 60;
        LocalTime horaTotal =LocalTime.of(horas,min);

        shopping.setTotalQuantity( totalQuantity);
        shopping.setTotalAmount(totalAmount);
        shopping.setTotalTime(horaTotal);
        shopping.setOrders(orders);
         shoppingRepository.save(shopping);
        return "se realizo exitosamente el guardado del shopping";
    }

    @Override
    public Shopping getShopping(Long shoppingId) {
        return shoppingRepository.findById(shoppingId).orElse(null);
    }

    @Override
    public List<Shopping> getAllShopping() {
        return (List<Shopping>) shoppingRepository.findAll();
    }

    @Override
    public void deleteShopping(Long shoppingId) {

    }
}
