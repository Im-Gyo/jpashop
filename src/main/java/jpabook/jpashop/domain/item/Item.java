package jpabook.jpashop.domain.item;


import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==// 재고가 늘고 줄고, 데이터를 가지고 있는 곳에서 비즈니스 로직이 나가야 응집도가 높음
    /**
     * stock 증가
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }


}
