package com.davyd.shop.controller;

import com.davyd.shop.dto.request.CategoryRequest;
import com.davyd.shop.dto.response.CategoryResponse;
import com.davyd.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void save(@Valid @RequestBody CategoryRequest request) {
        categoryService.save(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return categoryService.findAll(fieldName);
    }

    @PutMapping
    public void update(@Valid @RequestBody CategoryRequest request, Long id) {
        categoryService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id) {
        categoryService.delete(id);
    }

}
