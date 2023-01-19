package com.example.kcalog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    @Column(name = "meal_type")
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "record")
    private List<RecordItem> recordItems = new ArrayList<RecordItem>();

    @Builder
    private Record(MealType mealType, LocalDate date, List<RecordItem> recordItems) {
        this.mealType = mealType;
        this.date = date;
        this.recordItems = recordItems;
    }

    //== 비즈니스 로직 ==//
    public float getRecordTotalKcal() {
        float totalKcal = 0;
        for (RecordItem recordItem : recordItems) {
            totalKcal += recordItem.getTotalKcal();
        }
        return totalKcal;
    }

    public float getRecordTotalGram() {
        float totalGram = 0;
        for (RecordItem recordItem : recordItems) {
            totalGram += recordItem.getTotalGram();
        }
        return totalGram;
    }
    public float getRecordTotalCarb() {
        float totalCarb = 0;
        for (RecordItem recordItem : recordItems) {
            totalCarb += recordItem.getTotalCarb();
        }
        return totalCarb;
    }

    public float getRecordTotalProtein() {
        float totalProtein = 0;
        for (RecordItem recordItem : recordItems) {
            totalProtein += recordItem.getTotalProtein();
        }
        return totalProtein;
    }

    public float getRecordTotalFat() {
        float totalFat = 0;
        for (RecordItem recordItem : recordItems) {
            totalFat += recordItem.getTotalFat();
        }
        return totalFat;
    }

    public void update(MealType mealType, List<RecordItem> recordItems) {
        this.date = LocalDate.now();
        this.mealType = mealType;
        this.recordItems = recordItems;
    }




}
