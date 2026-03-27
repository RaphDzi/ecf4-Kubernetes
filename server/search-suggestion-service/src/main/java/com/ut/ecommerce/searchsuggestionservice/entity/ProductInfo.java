package com.ut.ecommerce.searchsuggestionservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Version légère de ProductInfo — uniquement les champs nécessaires
 * pour construire les suggestions de recherche.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_info")
public class ProductInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_category_id")
    private GenderCategory genderCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apparel_category_id")
    private ApparelCategory apparelCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_brand_category_id")
    private ProductBrandCategory productBrandCategory;
}