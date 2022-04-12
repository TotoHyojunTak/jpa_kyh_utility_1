package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    // EntityManager
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    // 단건 조회
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll(){
        // JPA(JPQL)는 entity로 주고 받는다 (m으로 선언)
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 조건에 의한 조회문
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
