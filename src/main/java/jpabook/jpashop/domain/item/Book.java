package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")//저장해야할때 구분할 수 있어야함(싱글테이블에서)
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;

}
