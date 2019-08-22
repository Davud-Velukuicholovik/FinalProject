package com.davyd.shop.controller;

import com.davyd.shop.dto.request.SubcategoryRequest;

import com.davyd.shop.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping
    public void delete(Long id) {
        subcategoryService.delete(id);
    }
}
