package com.example.kcalog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class RecordItem {

    @Id
    @GeneratedValue
    @Column(name = "record_item_id")
    private long id;

    @Column(name = "count")
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private Record record;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Builder
    public RecordItem(int count,  Food food) {
        this.count = count;
        this.food = food;
    }

    //==음식 개수 당 총 영양소==//
    public float getTotalKcal() {
        return getFood().getKcal() * this.count;
    }

    public float getTotalGram() {
        return getFood().getGram() * this.count;
    }

    public float getTotalCarb() {
        return getFood().getCarb() * this.count;
    }

    public float getTotalProtein() {
        return getFood().getProtein() * this.count;
    }

    public float getTotalFat() {
        return getFood().getFat() * this.count;
    }
}
