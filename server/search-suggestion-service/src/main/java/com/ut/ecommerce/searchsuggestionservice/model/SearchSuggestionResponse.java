package com.ut.ecommerce.searchsuggestionservice.model;

import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForThreeAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionForTwoAttrDTO;
import com.ut.ecommerce.searchsuggestionservice.entity.ApparelCategory;
import com.ut.ecommerce.searchsuggestionservice.entity.GenderCategory;
import com.ut.ecommerce.searchsuggestionservice.entity.ProductBrandCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SearchSuggestionResponse implements Serializable {
    List<GenderCategory> genderKeywords;
    List<ProductBrandCategory> brandKeywords;
    List<ApparelCategory> apparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderApparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderBrandKeywords;
    List<SearchSuggestionForTwoAttrDTO> apparelBrandKeywords;
    List<SearchSuggestionForThreeAttrDTO> threeAttrKeywords;
    List<String> productKeywords;
}