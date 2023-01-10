package com.walton.springbootmall.rowmapper;

import com.walton.springbootmall.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();

        order.setOrderId(resultSet.getInt("order_id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setTotalAmount(resultSet.getInt("total_amount"));
        order.setCreatedDate(resultSet.getTimestamp("created_date"));
        order.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return order;
    }
}
