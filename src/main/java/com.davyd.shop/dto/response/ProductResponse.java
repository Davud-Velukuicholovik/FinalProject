package com.davyd.shop.dto.response;

import com.davyd.shop.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private String photo;
    private Double rating;
    private Long subcategoryId;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
        photo = product.getPhoto();
        rating = product.getRating();
        subcategoryId = product.getSubcategory().getId();
    }
}
