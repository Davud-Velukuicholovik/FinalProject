package com.davyd.shop.service;

import com.davyd.shop.dto.request.CategoryRequest;
import com.davyd.shop.dto.request.SubcategoryRequest;
import com.davyd.shop.entity.Category;
import com.davyd.shop.entity.Subcategory;
import com.davyd.shop.exception.HasDependenciesException;
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
    public void delete(Long id) {
        Subcategory subcategory = findOne(id);
        if (subcategory.getProducts().isEmpty()) {
            subcategoryRepository.delete(subcategory);
        } else {
            throw new HasDependenciesException("Cannot delete subcategory with id " + id + " because it has dependencies");
        }
    }
    public void update(SubcategoryRequest request, Long id) {
        subcategoryRepository.save(subcategoryRequestToSubcategory(findOne(id), request));
    }

    private Subcategory subcategoryRequestToSubcategory(
            Subcategory subcategory, SubcategoryRequest request) {
        if (subcategory == null) {
            subcategory = new Subcategory();
        }
        subcategory.setName(request.getName());
        return subcategory;
    }
}
