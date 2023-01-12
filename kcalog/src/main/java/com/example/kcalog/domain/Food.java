package com.example.kcalog.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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
}
