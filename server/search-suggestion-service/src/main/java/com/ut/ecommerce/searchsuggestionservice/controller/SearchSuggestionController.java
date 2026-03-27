package com.ut.ecommerce.searchsuggestionservice.controller;

import com.ut.ecommerce.searchsuggestionservice.model.SearchSuggestionResponse;
import com.ut.ecommerce.searchsuggestionservice.service.SearchSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search-suggestions")
@CrossOrigin(origins = "${REACT_CLIENT_URL:http://localhost:3000}")
public class SearchSuggestionController {

    @Autowired
    private SearchSuggestionService searchSuggestionService;

    /**
     * GET /api/search-suggestions
     * Retourne toutes les suggestions de recherche pour l'UI React.
     * Résultat mis en cache Redis côté service.
     */
    @GetMapping
    public ResponseEntity<?> getSearchSuggestions() {
        SearchSuggestionResponse response = searchSuggestionService.getSearchSuggestions();
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }
}