package com.sparta.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String foodName; //음식의 이름

    @Column(nullable = false)
    private int price; //음식의 가격

    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER) //mappedBy는 연관관계 주인을 지정 여기서는 "food"가 주인// Orders의 "food_Id"의 주인
    private List<Orders> orders = new ArrayList<>();

    public Food(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }
}
