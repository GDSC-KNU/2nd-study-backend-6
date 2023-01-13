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
public class RecordItem {

    @Id
    @GeneratedValue
    @Column(name = "record_item_id")
    private long id;

    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private Record record;

    @OneToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Builder
    private RecordItem(int count) {
        this.count = count;
    }
}
