package com.example.kcalog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Food {
    @Id @GeneratedValue
    @Column(name = "food_id")
    private Long id;

    private String name;

    private float kcal; //gram 당 kcal

    private float gram; //기준 gram

    private float protein; //단백질
    private float fat; //지방

    @Column(name = "carbohydrates")
    private float carb; //탄수화물

    @OneToOne(mappedBy = "food")
    private RecordItem recordItem;

    @Builder
    private Food(String name, float kcal, float gram, float protein, float fat, float carb) {
        this.name = name;
        this.kcal = kcal;
        this.gram = gram;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
    }
}
