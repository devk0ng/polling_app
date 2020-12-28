package com.works.polling_app.repository;

import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.answer.ObjectiveAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectiveAnswerRepository {

    private final EntityManager em;

    public void save(SubjectiveAnswer subjectiveAnswer){
        em.persist(subjectiveAnswer);
    }

    //특정 질문에 대한 대답들 반환
    public List<SubjectiveAnswer> findByQuestion(Question question){
        return em.createQuery("select s from SubjectiveAnswer s where s.question = :question ",SubjectiveAnswer.class)
                .setParameter("question",question)
                .getResultList();
    }
}
