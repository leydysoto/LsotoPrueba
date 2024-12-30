package com.desarrolladora.leydy.Barberia.Controller;

import com.desarrolladora.leydy.Barberia.entity.Orders;
import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.model.response.ApiResponse;
import com.desarrolladora.leydy.Barberia.service.OrdersService;
import com.desarrolladora.leydy.Barberia.utility.ConstantUtil;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/orders")
@RestController()
@AllArgsConstructor()
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping("/{appointmentDate}")
    public ResponseEntity<ApiResponse<List<Orders>>>  getAllOrders(@Valid @PathVariable String appointmentDate) {
        return ResponseEntity.ok(
                ApiResponse.<List<Orders>> builder()
                .code(ConstantUtil.OK_CODE)
                .message(ConstantUtil.OK_MESSAGE)
                .data(ordersService.getOrders(appointmentDate))
                .build()
        );
    }
}
