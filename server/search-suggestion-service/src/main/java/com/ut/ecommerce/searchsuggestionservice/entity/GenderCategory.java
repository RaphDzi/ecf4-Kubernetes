package com.ut.ecommerce.searchsuggestionservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "gender_category")
public class GenderCategory implements Serializable {

    @Id
    private int id;

    private String type;

    public GenderCategory(int id, String type) {
        this.id = id;
        this.type = type;
    }
}