package com.walton.springbootmall.service;

import com.walton.springbootmall.model.Product;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductService {
    Product getProductById(Integer productId);
}
