package com.desarrolladora.leydy.Barberia.service.impl;

import com.desarrolladora.leydy.Barberia.Repository.CategoryRepository;
import com.desarrolladora.leydy.Barberia.Repository.ProductRepository;
import com.desarrolladora.leydy.Barberia.dto.ProductDTO;
import com.desarrolladora.leydy.Barberia.entity.Category;
import com.desarrolladora.leydy.Barberia.entity.Product;
import com.desarrolladora.leydy.Barberia.mapper.ProductMapper;
import com.desarrolladora.leydy.Barberia.model.request.ProductRequest;
import com.desarrolladora.leydy.Barberia.model.request.PromotionRequest;
import com.desarrolladora.leydy.Barberia.service.ProductService;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private  ProductRepository productRepository;

    private  CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        System.out.println(productRequest);
        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setPrice(Double.parseDouble(productRequest.getPrice()));
        product.setDiscount(productRequest.getDiscount());
        product.setStock(productRequest.getStock());
        product.setDuration(productRequest.getDuration());
        //--------encontrar la categoria relacionada
        Category category=categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(()->new IllegalArgumentException("categoria no encontrada con el id:"+ productRequest.getCategoryId()));
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product>updateDiscount(PromotionRequest promotionRequest) {
        List<Product> listProduct=new ArrayList<>();
        Product product;
        for(Long productId:promotionRequest.getProductIds()){
            product =productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("producto no encontrado"+productId));
            product.setDiscount(promotionRequest.getDiscount());
            productRepository.save(product);
            listProduct.add(product);
        }
        return listProduct;

    }

    @Override
    public List<Product> getFindByDiscount(Integer discount) {
        return productRepository.findByDiscount(discount);
    }

    @Override
    public List<Product> getFindByCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->new IllegalArgumentException("no se encuentra la categoria con el id: "+categoryId));
        return productRepository.findByCategory(category);
    }

    @Override
    public ProductDTO getProductById(Long productId){
        Product product =productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("producto no encontrado"+productId));
        return productMapper.toProductDTO(product);
    }
}
