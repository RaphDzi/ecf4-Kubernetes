package com.ut.ecommerce.searchsuggestionservice.service;

import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForThreeAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.entity.ApparelCategory;
import com.ut.ecommerce.searchsuggestionservice.entity.GenderCategory;
import com.ut.ecommerce.searchsuggestionservice.entity.ProductBrandCategory;
import com.ut.ecommerce.searchsuggestionservice.model.SearchSuggestionResponse;
import com.ut.ecommerce.searchsuggestionservice.repository.ApparelCategoryRepository;
import com.ut.ecommerce.searchsuggestionservice.repository.GenderCategoryRepository;
import com.ut.ecommerce.searchsuggestionservice.repository.ProductBrandCategoryRepository;
import com.ut.ecommerce.searchsuggestionservice.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSuggestionServiceImpl implements SearchSuggestionService {

    @Autowired
    private GenderCategoryRepository genderCategoryRepository;

    @Autowired
    private ProductBrandCategoryRepository productBrandCategoryRepository;

    @Autowired
    private ApparelCategoryRepository apparelCategoryRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * Construit la réponse complète de suggestions de recherche.
     * Le résultat est mis en cache Redis sous la clé "searchSuggestions"
     * pour éviter des requêtes SQL répétées (données rarement modifiées).
     */
    @Override
    @Cacheable(value = "searchSuggestions", key = "'all'")
    public SearchSuggestionResponse getSearchSuggestions() {

        List<GenderCategory> genderKeywords = genderCategoryRepository.findAll();
        List<ProductBrandCategory> brandKeywords = productBrandCategoryRepository.findAll();
        List<ApparelCategory> apparelKeywords = apparelCategoryRepository.findAll();

        List<SearchSuggestionForTwoAttrDTO> genderApparelKeywords =
                productInfoRepository.findDistinctGenderApparelCombinations();

        List<SearchSuggestionForTwoAttrDTO> genderBrandKeywords =
                productInfoRepository.findDistinctGenderBrandCombinations();

        List<SearchSuggestionForTwoAttrDTO> apparelBrandKeywords =
                productInfoRepository.findDistinctApparelBrandCombinations();

        List<SearchSuggestionForThreeAttrDTO> threeAttrKeywords =
                productInfoRepository.findDistinctThreeAttrCombinations();

        List<String> productKeywords = productInfoRepository.findDistinctProductNames();

        return new SearchSuggestionResponse(
                genderKeywords,
                brandKeywords,
                apparelKeywords,
                genderApparelKeywords,
                genderBrandKeywords,
                apparelBrandKeywords,
                threeAttrKeywords,
                productKeywords
        );
    }
}