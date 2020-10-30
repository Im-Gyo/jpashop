package jpabook.jpashop.domain.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속관계전략지정(싱글테이블)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    //구현체를 가지고 할것이기 때문에 추상클래스로 만듬

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;
    private int stockQuantity;
}
