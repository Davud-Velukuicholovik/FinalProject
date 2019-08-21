package com.davyd.shop.service;

import com.davyd.shop.dto.request.SubcategoryRequest;
import com.davyd.shop.entity.Category;
import com.davyd.shop.entity.Subcategory;
import com.davyd.shop.exception.NoMatchesException;
import com.davyd.shop.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService categoryService;

    public void save(SubcategoryRequest request) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(request.getName());
        Category category = categoryService.findOne(request.getCategoryId());
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);
    }

    public Subcategory findOne(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new NoMatchesException("Subcategory with id " + id + " not exists"));
    }
}
