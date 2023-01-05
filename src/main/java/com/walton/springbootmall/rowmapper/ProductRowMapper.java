package com.walton.springbootmall.rowmapper;

import com.walton.springbootmall.constant.ProductCategory;
import com.walton.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        //String 轉 Enum
        String categoryStr = resultSet.getString("category");
        //根據傳進來的Str, 找尋ProductCategory有沒有對應的值，有的話就讓product set好
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);

        //法二
//        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));

        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
