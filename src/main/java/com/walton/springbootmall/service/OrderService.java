package com.walton.springbootmall.service;

import com.walton.springbootmall.dto.CreateOrderRequest;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
