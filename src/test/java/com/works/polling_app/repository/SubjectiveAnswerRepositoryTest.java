package com.works.polling_app.repository;

import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.answer.ObjectiveAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class SubjectiveAnswerRepositoryTest {

    @Autowired SubjectiveAnswerRepository subjectiveAnswerRepository;
    @Autowired QuestionRepository questionRepository;

    @Test
    void save() {
        //given
        Question question = questionRepository.findOne(19l);
        SubjectiveAnswer subjectiveAnswer = new SubjectiveAnswer();
        subjectiveAnswer.setAnswer("good");
        subjectiveAnswer.setQuestion(question);

        SubjectiveAnswer subjectiveAnswer2 = new SubjectiveAnswer();
        subjectiveAnswer2.setAnswer("fine");
        subjectiveAnswer2.setQuestion(question);

        //when
        subjectiveAnswerRepository.save(subjectiveAnswer);
        subjectiveAnswerRepository.save(subjectiveAnswer2);


        //then
    }


}