package com.walton.springbootmall.service;

import com.walton.springbootmall.dto.ProductRequest;
import com.walton.springbootmall.model.Product;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
