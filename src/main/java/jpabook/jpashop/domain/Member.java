package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded   // 내장타입을 포함헀다는 어노테이션으로 매핑
    private Address address;

    @OneToMany(mappedBy = "member") // 멤버입장에서 리스트는 하나의 회원이 여러개 상품을 주문을 하기 떄문에 일대다, 연관관계의 주인이 아니라 매핑된 거울임(mappedBy = member) order테이블에 있는 member필드에  의해 매핑)
    private List<Order> orders = new ArrayList<>();

}
