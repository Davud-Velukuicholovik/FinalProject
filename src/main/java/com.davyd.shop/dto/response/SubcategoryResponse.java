package com.davyd.shop.dto.response;

import com.davyd.shop.entity.Subcategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryResponse {
    private Long id;
    private String name;

    public SubcategoryResponse(Subcategory subcategory) {
        id = subcategory.getId();
        name = subcategory.getName();
    }
}
