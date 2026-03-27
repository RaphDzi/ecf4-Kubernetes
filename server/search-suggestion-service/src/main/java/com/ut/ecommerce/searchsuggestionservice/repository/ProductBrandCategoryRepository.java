package com.ut.ecommerce.searchsuggestionservice.repository;

import com.ut.ecommerce.searchsuggestionservice.entity.ProductBrandCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBrandCategoryRepository extends JpaRepository<ProductBrandCategory, Integer> {
}