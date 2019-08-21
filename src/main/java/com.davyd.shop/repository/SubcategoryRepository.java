package com.davyd.shop.repository;


import com.davyd.shop.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {


    @Query("from Subcategory s join s.category c where c.id=:categoryaaaId")
    List<Subcategory> findAllByCategoryId(@Param("categoryaaaId") Long categoryId);
}
