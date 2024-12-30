package com.desarrolladora.leydy.Barberia.service;

import com.desarrolladora.leydy.Barberia.dto.DetailsDTO;
import com.desarrolladora.leydy.Barberia.dto.ProductDTO;
import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.model.request.ProductRequest;
import com.desarrolladora.leydy.Barberia.model.request.PromotionRequest;

import java.util.List;

public interface ProductService {

    //-------------------------Crear Product----------------------------------//
    Product createProduct(ProductRequest productRequest);

    //-------------------------lista de products----------------------------------//
    List<Product> getAllProduct();

    //-------------------------get product----------------------------------//
    ProductDTO getProductById(Long productId);

    //---------------Editar el discount del product por promocion, masivamente---------------//
    List<Product> updateDiscount(PromotionRequest promotionRequest);

    //----------products segun propiedad discount--------------------------------//
    List<Product> getFindByDiscount(Integer discount);

    //---------- products segun propiedad categoria-----------------------------------------//
    List<Product>  getFindByCategory(Long categoryId);

    //---------- product details -----------------------------------------//
    DetailsDTO getProductDetailsById(Long productId);
}
