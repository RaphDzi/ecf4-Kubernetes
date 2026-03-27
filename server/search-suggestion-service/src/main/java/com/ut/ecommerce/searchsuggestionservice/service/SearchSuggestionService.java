package com.ut.ecommerce.searchsuggestionservice.service;

import com.ut.ecommerce.searchsuggestionservice.model.SearchSuggestionResponse;

public interface SearchSuggestionService {

    /**
     * Retourne l'ensemble des suggestions de recherche :
     * mots-clés simples (genre, marque, vêtement), combinaisons à 2 et 3 attributs,
     * et noms de produits.
     */
    SearchSuggestionResponse getSearchSuggestions();
}