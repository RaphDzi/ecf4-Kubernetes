package com.ut.ecommerce.searchsuggestionservice.repository;

import com.ut.ecommerce.searchsuggestionservice.entity.ApparelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparelCategoryRepository extends JpaRepository<ApparelCategory, Integer> {
}