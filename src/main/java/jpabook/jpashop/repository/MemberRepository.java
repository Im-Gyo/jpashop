package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.*;
import java.util.List;

@Repository
public class MemberRepository {

    //@PersistenceContext JPA가 제공하는 표준어노테이션
    private final EntityManager em; //Spring이 엔티티매니저를 만들어서 여기에 주입해줌

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){ //조회
        return em.find(Member.class, id); //JPA가 제공하는 find메서드로 id값을 넘기면 멤버를 찾아서 반환해줌
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery(  "select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
