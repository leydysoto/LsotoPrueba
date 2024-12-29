package com.desarrolladora.leydy.Barberia.Controller;

import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.model.request.ProductRequest;
import com.desarrolladora.leydy.Barberia.model.request.PromotionRequest;
import com.desarrolladora.leydy.Barberia.model.response.ApiResponse;
import com.desarrolladora.leydy.Barberia.service.ProductService;
import com.desarrolladora.leydy.Barberia.utility.ConstantUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    //----------crear productos----------------------------------------//
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(
                ApiResponse.<Product>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(productService.createProduct(productRequest))
                        .build()
        );
    }
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(){
        return ResponseEntity.ok(
                ApiResponse.<List<Product>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(productService.getAllProduct())
                        .build()
        );
    }

    //---------- productos actualizados en descuento por promoción----------------------------------------//
    @PutMapping("/discount")
    public ResponseEntity<ApiResponse<List<Product>>>updateDiscount(@Valid @RequestBody PromotionRequest promotionRequest){
        return ResponseEntity.ok(
                ApiResponse.<List<Product>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(productService.updateDiscount(promotionRequest))
                        .build()
        );
    }

    //---------- productos segun propiedad discount----------------------------------------//
    @GetMapping("discount/{discount}")
    public ResponseEntity<ApiResponse<List<Product>>> getFindByDiscount(@Valid @PathVariable Integer discount){
        return  ResponseEntity.ok(
                ApiResponse.<List<Product>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(productService.getFindByDiscount(discount))
                        .build()
        );
    }

    //---------- productos segun propiedad categoria-----------------------------------------//
    @GetMapping("category/{categoryId}")
    public ResponseEntity<ApiResponse<List<Product>>> getFindByCategory(@Valid @PathVariable Long categoryId){
        return  ResponseEntity.ok(
                ApiResponse.<List<Product>>builder()
                        .code(ConstantUtil.OK_CODE)
                        .message(ConstantUtil.OK_MESSAGE)
                        .data(productService.getFindByCategory(categoryId))
                        .build()
        );
    }


}
