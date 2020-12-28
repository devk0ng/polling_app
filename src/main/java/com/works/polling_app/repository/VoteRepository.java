package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.Survey;
import com.works.polling_app.domain.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VoteRepository {

    private final EntityManager em;

    //vote 관계 테이블 저장
    public void save(Vote vote){
        em.persist(vote);
    }

    //특정 회원을 바탕으로 투표한 vote 정보 반환
    public List<Vote> findByMember(Member member){
        return em.createQuery("select v from Vote v where v.member = :member ",Vote.class)
                .setParameter("member",member)
                .getResultList();
    }
}
