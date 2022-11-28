package com.sparta.springjpa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "food_Id") //Orders와 Food를 Join함. 그리고 "food_id"의 주인은 Food class에 나옴
    private Food food;

    @ManyToOne

    @JoinColumn(name = "memeberId") //Orders와 Member를 Joing함. 그리고 "memberId의 주인은 Member class에서 지정
    private Member member;

    public Orders(Food food, Member member) {
        this.food = food;
        this.member = member;
    }
}
