package com.example.kcalog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Answer {

    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "answer_content")
    private String content;

    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    @ManyToOne
    @JoinColumn(name = "recommend_id")
    private Recommend recommend;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Answer(String content, Emotion emotion) {
        this.content = content;
        this.emotion = emotion;
    }
}
