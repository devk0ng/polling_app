package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyRepository {
    private final EntityManager em;

    public void save(Survey survey){
        em.persist(survey);
    }

    //회원바탕 자신이 만든 설문조사 조회
    public List<Survey> findByMember(Long id){
        return em.createQuery("select s from Survey s where s.member.id = :id",Survey.class)
                .setParameter("id",id)
                .getResultList();
    }

    //설문조사 하나 조회
    public Survey findOne(Long id){
        return em.find(Survey.class, id);
    }

    //전체 설문조사 조회
    public List<Survey> findAll(){
        return em.createQuery("select s from Survey s",Survey.class).getResultList();
    }
}
