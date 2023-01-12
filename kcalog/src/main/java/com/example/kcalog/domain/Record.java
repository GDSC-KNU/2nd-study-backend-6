package com.example.kcalog.domain;

import com.example.kcalog.domain.MealType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Record {
    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    @Column(name = "meal_type")
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "record")
    private List<RecordItem> recordItems = new ArrayList<RecordItem>();
}