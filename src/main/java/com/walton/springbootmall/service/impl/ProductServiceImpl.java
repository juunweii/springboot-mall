package com.walton.springbootmall.service.impl;

import com.walton.springbootmall.dao.ProductDao;
import com.walton.springbootmall.dto.ProductRequest;
import com.walton.springbootmall.model.Product;
import com.walton.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }
}
