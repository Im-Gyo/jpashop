package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order; //order와 관계를 가짐

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // Enum타입은 이 어노테이션을 넣어야함, 타입을 넣을 때 ORDINAL은 숫자로 컬럼이 들어감(문제는 중간에 어떤 다른 상태가 들어가면 안됨)
                                    // 그래서 꼭 String으로 써야함
    private DeliveryStatus status; // READY, COMP
}
