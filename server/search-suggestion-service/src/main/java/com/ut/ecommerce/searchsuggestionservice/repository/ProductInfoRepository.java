package com.ut.ecommerce.searchsuggestionservice.repository;

import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForThreeAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    // Combinaisons gender + apparel
    @Query("SELECT DISTINCT new com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO(" +
           "p.genderCategory.id, p.genderCategory.type, p.apparelCategory.id, p.apparelCategory.type) " +
           "FROM ProductInfo p WHERE p.genderCategory IS NOT NULL AND p.apparelCategory IS NOT NULL")
    List<SearchSuggestionForTwoAttrDTO> findDistinctGenderApparelCombinations();

    // Combinaisons gender + brand
    @Query("SELECT DISTINCT new com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO(" +
           "p.genderCategory.id, p.genderCategory.type, p.productBrandCategory.id, p.productBrandCategory.type) " +
           "FROM ProductInfo p WHERE p.genderCategory IS NOT NULL AND p.productBrandCategory IS NOT NULL")
    List<SearchSuggestionForTwoAttrDTO> findDistinctGenderBrandCombinations();

    // Combinaisons apparel + brand
    @Query("SELECT DISTINCT new com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO(" +
           "p.apparelCategory.id, p.apparelCategory.type, p.productBrandCategory.id, p.productBrandCategory.type) " +
           "FROM ProductInfo p WHERE p.apparelCategory IS NOT NULL AND p.productBrandCategory IS NOT NULL")
    List<SearchSuggestionForTwoAttrDTO> findDistinctApparelBrandCombinations();

    // Combinaisons gender + apparel + brand
    @Query("SELECT DISTINCT new com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForThreeAttrDTO(" +
           "p.genderCategory.id, p.genderCategory.type, " +
           "p.apparelCategory.id, p.apparelCategory.type, " +
           "p.productBrandCategory.id, p.productBrandCategory.type) " +
           "FROM ProductInfo p WHERE p.genderCategory IS NOT NULL AND p.apparelCategory IS NOT NULL AND p.productBrandCategory IS NOT NULL")
    List<SearchSuggestionForThreeAttrDTO> findDistinctThreeAttrCombinations();

    // Noms de produits distincts
    @Query("SELECT DISTINCT p.productName FROM ProductInfo p WHERE p.productName IS NOT NULL")
    List<String> findDistinctProductNames();
}