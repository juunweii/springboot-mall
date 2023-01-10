package com.walton.springbootmall.service.impl;

import com.walton.springbootmall.dao.OrderDao;
import com.walton.springbootmall.dao.ProductDao;
import com.walton.springbootmall.dto.BuyItem;
import com.walton.springbootmall.dto.CreateOrderRequest;
import com.walton.springbootmall.model.Order;
import com.walton.springbootmall.model.OrderItem;
import com.walton.springbootmall.model.Product;
import com.walton.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {


        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //Count total amount
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            //Convert BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //Create Order，在兩張table都插入數據
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }
}
