package com.example.kcalog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String name;

    private float height;

    private float weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "day_kcal")
    private float dayKcal;

    @Column(name = "target_weight")
    private float targetWeight;

    @OneToMany(mappedBy = "member")
    private List<Record> records = new ArrayList<Record>();

    @OneToMany(mappedBy = "member")
    private List<Recommend> Recommends = new ArrayList<Recommend>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<Answer>();

    @Builder
    private Member(String email, String password, String name, float height, float weight, Gender gender, float dayKcal, float targetWeight) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.dayKcal = dayKcal;
        this.targetWeight = targetWeight;
    }

}
