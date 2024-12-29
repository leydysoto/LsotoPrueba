package com.desarrolladora.leydy.Barberia.Controller;

import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.entity.Shopping;
import com.desarrolladora.leydy.Barberia.model.request.ProductRequest;
import com.desarrolladora.leydy.Barberia.model.request.ShoppingRequest;
import com.desarrolladora.leydy.Barberia.model.response.ApiResponse;
import com.desarrolladora.leydy.Barberia.service.ShoppingService;
import com.desarrolladora.leydy.Barberia.utility.ConstantUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shopping")
public class ShoppingController {
 private final ShoppingService shoppingService;
    @PostMapping
    public ResponseEntity<ApiResponse<String>> createShopping(@Valid @RequestBody ShoppingRequest shoppingRequest){
        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(shoppingService.createShopping(shoppingRequest))
                        .build()
        );
    }
    @GetMapping("/{shoppingId}")
    public ResponseEntity<ApiResponse<Shopping>> getShopping(@Valid @PathVariable Long shoppingId) {
        return  ResponseEntity.ok(
                ApiResponse.<Shopping>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(shoppingService.getShopping(shoppingId))
                        .build()
        );
    }
    @GetMapping()
    public ResponseEntity<ApiResponse<List<Shopping>>> getAllShopping() {
        return  ResponseEntity.ok(
                ApiResponse.<List<Shopping>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(shoppingService.getAllShopping())
                        .build()
        );
    }
}
