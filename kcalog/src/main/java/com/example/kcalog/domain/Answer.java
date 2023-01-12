package com.example.kcalog.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Answer {

    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "answer_content")
    private String ansContent;

    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    @ManyToOne
    @JoinColumn(name = "recommend_id")
    private Recommend recommend;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
