package com.sparta.springjpa.repository;

import com.sparta.springjpa.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    //인터페이스 FoodRepository는 JpaRepository의 상속을 받아서 Food테이블과 연결하겠다. // Long은 아이디 값
}

