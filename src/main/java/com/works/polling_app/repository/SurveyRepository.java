package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
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

    public Survey findOne(Long id){
        return em.find(Survey.class, id);
    }

    public List<Survey> findAll(){
        return em.createQuery("select s from Survey s",Survey.class).getResultList();
    }
}
