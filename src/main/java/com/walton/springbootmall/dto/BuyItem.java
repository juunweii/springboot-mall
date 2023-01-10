package com.walton.springbootmall.dto;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class BuyItem {

    private Integer productId;
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
