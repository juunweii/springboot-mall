package com.walton.springbootmall.dao;

import com.walton.springbootmall.constant.ProductCategory;
import com.walton.springbootmall.dto.ProductRequest;
import com.walton.springbootmall.model.Product;

import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);


    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
