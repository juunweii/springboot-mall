package com.walton.springbootmall.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class CreateOrderRequest {

    @NotEmpty
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}