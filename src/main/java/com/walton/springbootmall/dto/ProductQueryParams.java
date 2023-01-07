package com.walton.springbootmall.dto;

import com.walton.springbootmall.constant.ProductCategory;

/**
 * @author Walton Hung (chunweih@andrew.cmu.edu)
 */
public class ProductQueryParams {
    private ProductCategory category;
    private String search;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
