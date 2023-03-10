package com.walton.springbootmall.dao;

import com.walton.springbootmall.dto.ProductQueryParams;
import com.walton.springbootmall.dto.ProductRequest;
import com.walton.springbootmall.model.Product;

import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


    void updateStock(Integer productId, int stock);
}
