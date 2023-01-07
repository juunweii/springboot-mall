package com.walton.springbootmall.dao;

import com.walton.springbootmall.dto.ProductRequest;
import com.walton.springbootmall.model.Product;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
