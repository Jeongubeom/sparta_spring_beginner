package com.sparta.springjpa.repository;

import com.sparta.springjpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //인터페이스 MemberRepository는 JpaRepository의 상속을 받아서 Member테이블과 연결하겠다. // Long은 아이디 값
}
