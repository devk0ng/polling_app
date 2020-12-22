package com.works.polling_app.repository;

import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.answer.ObjectiveAnswer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class ObjectiveAnswerRepositoryTest {

    @Autowired ObjectiveAnswerRepository objectiveAnswerRepository;
    @Autowired QuestionRepository questionRepository;

    @Test
    void save() {
        //given
        Question question = questionRepository.findOne(15l);
        ObjectiveAnswer objectiveAnswer = new ObjectiveAnswer();
        objectiveAnswer.setAnswer("blue");
        objectiveAnswer.setCount(0);
        objectiveAnswer.setQuestion(question);

        ObjectiveAnswer objectiveAnswer2 = new ObjectiveAnswer();
        objectiveAnswer2.setAnswer("red");
        objectiveAnswer2.setCount(0);
        objectiveAnswer2.setQuestion(question);

        //when
        objectiveAnswerRepository.save(objectiveAnswer);
        objectiveAnswerRepository.save(objectiveAnswer2);


        //then

    }

    @Test
    void findByQuestion() {
    }
}