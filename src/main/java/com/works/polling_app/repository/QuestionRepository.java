package com.works.polling_app.repository;

import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final EntityManager em;

    public void save(Question question){
        em.persist(question);
    }

    public Question findOne(Long id){
        return em.find(Question.class, id);
    }

    public List<Question> findBySurvey(Survey survey){
        return em.createQuery("select q from Question q where q.survey=:survey",Question.class)
                .setParameter("survey",survey)
                .getResultList();
    }


}
