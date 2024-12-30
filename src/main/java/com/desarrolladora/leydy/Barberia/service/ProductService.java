package com.desarrolladora.leydy.Barberia.service;

import com.desarrolladora.leydy.Barberia.dto.ProductDTO;
import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.model.request.ProductRequest;
import com.desarrolladora.leydy.Barberia.model.request.PromotionRequest;

import java.util.List;

public interface ProductService {

    //-------------------------Crear Producto-----------------------------------//
    Product createProduct(ProductRequest productRequest);

    //-------------------------lista de productos----------------------------------//
    List<Product> getAllProduct();

    //-------------------------get producto----------------------------------//
    ProductDTO getProductById(Long productId);

    //---------------Editar el discount del producto por promocion, masivamente---------------//
    List<Product> updateDiscount(PromotionRequest promotionRequest);

    //----------productos segun propiedad discount--------------------------------//
    List<Product> getFindByDiscount(Integer discount);

    //---------- productos segun propiedad categoria-----------------------------------------//
    List<Product>  getFindByCategory(Long categoryId);
}
