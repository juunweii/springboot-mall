package com.walton.springbootmall.service.impl;

import com.walton.springbootmall.dao.OrderDao;
import com.walton.springbootmall.dao.ProductDao;
import com.walton.springbootmall.dao.UserDao;
import com.walton.springbootmall.dto.BuyItem;
import com.walton.springbootmall.dto.CreateOrderRequest;
import com.walton.springbootmall.model.Order;
import com.walton.springbootmall.model.OrderItem;
import com.walton.springbootmall.model.Product;
import com.walton.springbootmall.model.User;
import com.walton.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    @Autowired
    private UserDao userDao;

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        //Check if user exist
        User user = userDao.getUserById(userId);

        if (user == null) {
            log.warn("userId{} not exist", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //Check if product exist and have enough stock
            if (product == null) {
                log.warn("Product {} not exist", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("Product {} don't have enough quantity. Quantity left: {}", buyItem.getProductId(), product.getStock());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //Subtract product stock
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

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
