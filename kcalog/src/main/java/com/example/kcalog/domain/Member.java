package com.example.kcalog.domain;

import com.example.kcalog.domain.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

}
