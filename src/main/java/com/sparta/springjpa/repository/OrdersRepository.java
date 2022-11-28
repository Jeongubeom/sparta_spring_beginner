package com.sparta.springjpa.repository;

import com.sparta.springjpa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    //인터페이스 OrdersRepository는 JpaRepository의 상속을 받아서 Orders테이블과 연결하겠다. // Long은 아이디 값
}
