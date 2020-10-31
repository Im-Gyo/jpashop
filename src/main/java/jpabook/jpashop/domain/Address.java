package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //JPA내장타입
@Getter
public class Address {  // 값 타입은 변경 불가능하게 설계

    private  String city;
    private  String street;
    private  String zipcode;

    protected Address() {   //JPA스펙상 생성자를 만듬(Embeddable)
    }

    public Address(String city, String street, String zipcode) {    // 생성자에서 값을 모두 초기화해 변경 불가능한 클래스를 만듬
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
