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
public class Recommend {
    @Id @GeneratedValue
    @Column(name = "recommend_id")
    private Long id;

    @Column(name = "recommend_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "recommend")
    private List<Answer> answers = new ArrayList<Answer>();

    @Builder
    private Recommend(String content) {
        this.content = content;
    }
}
