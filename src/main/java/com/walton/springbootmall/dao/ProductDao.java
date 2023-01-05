package com.walton.springbootmall.dao;

import com.walton.springbootmall.model.Product;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface ProductDao {

    Product getProductById(Integer productId);
}
