package com.example.kcalog.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Recommend {
    @Id @GeneratedValue
    @Column(name = "recommend_id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "recommend")
    private List<Answer> answers = new ArrayList<Answer>();
}
