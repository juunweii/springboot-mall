package com.walton.springbootmall.dao;

import com.walton.springbootmall.dto.CreateOrderRequest;
import com.walton.springbootmall.model.Order;
import com.walton.springbootmall.model.OrderItem;

import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
