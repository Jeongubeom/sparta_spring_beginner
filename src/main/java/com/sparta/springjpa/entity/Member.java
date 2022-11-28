package com.sparta.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter //값을 가져올 때 사용 json get방식과 유사
@Entity //실제 database의 테이블과 1:1로 매핑되는 객체
@NoArgsConstructor //기본생성자 만들어 주는 키워드
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER) // mappedBy의 연관관계의 주인을 "member" 라고 설정. Orders에 연관관계가 나옴
    private List<Orders> orders = new ArrayList<>();

    public Member(String memberName){
        this.memberName = memberName;
    }


}
