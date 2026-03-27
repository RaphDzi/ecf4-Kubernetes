package com.ut.ecommerce.searchsuggestionservice.repository;

import com.ut.ecommerce.searchsuggestionservice.entity.GenderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderCategoryRepository extends JpaRepository<GenderCategory, Integer> {
}