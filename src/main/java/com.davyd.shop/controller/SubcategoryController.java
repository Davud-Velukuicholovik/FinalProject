package com.davyd.shop.controller;

import com.davyd.shop.dto.request.SubcategoryRequest;

import com.davyd.shop.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@Valid @RequestBody SubcategoryRequest request) {
        subcategoryService.save(request);
    }
}
