package com.walton.springbootmall.service;

import com.walton.springbootmall.dto.CreateOrderRequest;
import com.walton.springbootmall.dto.OrderQueryParams;
import com.walton.springbootmall.model.Order;

import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
