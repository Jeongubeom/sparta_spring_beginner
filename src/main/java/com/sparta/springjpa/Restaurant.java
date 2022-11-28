package com.sparta.springjpa;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Member;
import com.sparta.springjpa.entity.Orders;
import com.sparta.springjpa.repository.FoodRepository;
import com.sparta.springjpa.repository.MemberRepository;
import com.sparta.springjpa.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor

public class Restaurant implements ApplicationRunner {
    private final FoodRepository foodRepository;
    private final OrdersRepository ordersRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Food> foods = new ArrayList<>();
        Food food1 = new Food("후라이드", 10000);
        Food food2 = new Food("양념치킨", 11000);
        Food food3 = new Food("반반치킨", 13000);
        Food food4 = new Food("고구마피자", 9000);
        Food food5 = new Food("아보카도피자", 110000);
        foods.add(food5);
        foodRepository.saveAll(foods);

        List<Member> members = new ArrayList<>();
        Member member1 = new Member("삼식이");
        Member member2 = new Member("먹깨비");
        memberRepository.saveAll(members);

        System.out.println("================================================");

        System.out.println("Member 데이터");
        List<Member> findMembers = memberRepository.findAll();
        for (Member findMember : findMembers) {
            System.out.println("fingMember = " + findMember.getMemberName());
        }
        System.out.println("================================================");

        System.out.println("Food 데이터");
        List<Food> findFoods = foodRepository.findAll();
        for (Food findFood : findFoods) {
            System.out.println("findFood  = " + findFood.getFoodName());
        }
        List<Orders> ordersList = new ArrayList<>();
        Orders order1 = new Orders(findFoods.get(0), findMembers.get(0));
        Orders order2 = new Orders(findFoods.get(3), findMembers.get(1));
        Orders order3 = new Orders(findFoods.get(4), findMembers.get(1));
        Orders order4 = new Orders(findFoods.get(2), findMembers.get(0));
        Orders order5 = new Orders(findFoods.get(2), findMembers.get(0));
        Orders order6 = new Orders(findFoods.get(1), findMembers.get(0));
        Orders order7 = new Orders(findFoods.get(1), findMembers.get(0));
        Orders order8 = new Orders(findFoods.get(3), findMembers.get(0));
        ordersList.add(order8);
        ordersRepository.saveAll(ordersList);

        System.out.println("===========================================================");
        int num = 1;
        System.out.println("Orders 데이터");
        List<Orders> orderList = ordersRepository.findAll();

        for (Orders orders : ordersList) {
            System.out.println(num);
            System.out.println("주문한 사람 = " + orders.getMember().getMemberName());
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            num++;
        }
        System.out.println("===========================================================");
        System.out.println("삼식이 주문한 음식");
        Member samsik = memberRepository.findById(1L).orElseThrow(()->new RuntimeException("없음"));


        num = 1;
        for (Orders orders : samsik.getOrders()) {
            System.out.println(num);
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            System.out.println("주문한 음식 가격 = " + orders.getFood().getFoodName());
            num++;
        }
        System.out.println("===========================================================");

        System.out.println("아보카도피자 주문한 사람");
        Food abocado = foodRepository.findById(5L).orElseThrow(() -> new RuntimeException("없음"));


        for (Orders order : abocado.getOrders()) {
            System.out.println("주문한 사람 = " + order.getMember().getMemberName());
        }
    }
}

