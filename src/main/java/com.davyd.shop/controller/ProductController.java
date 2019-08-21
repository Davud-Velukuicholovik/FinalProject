package com.davyd.shop.controller;

import com.davyd.shop.dto.request.ProductRequest;
import com.davyd.shop.dto.response.PageResponse;
import com.davyd.shop.dto.response.ProductResponse;
import com.davyd.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(@Valid @RequestBody ProductRequest request) throws IOException {
        productService.save(request);
    }

    @GetMapping
    public PageResponse<ProductResponse> findPage(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "name") String fieldName,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
            ) {
        return productService.findPage(page, size, fieldName, direction);
    }

    @PutMapping
    public void update(@Valid @RequestBody ProductRequest request, Long id) throws IOException {
        productService.update(request, id);
    }
}
