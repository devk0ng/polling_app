package com.works.polling_app.repository;

import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.QuestionStatus;
import com.works.polling_app.domain.Survey;
import com.works.polling_app.domain.answer.ObjectiveAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import org.apache.catalina.filters.ExpiresFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class QuestionRepositoryTest {

    @Autowired QuestionRepository questionRepository;
    @Autowired SurveyRepository surveyRepository;

    @Test
    void sbjsave() {
        //(String ask, QuestionStatus type, Survey survey, List<SubjectiveAnswer> subjectiveAnswer, List<ObjectiveAnswer> objectiveAnswer)

        //given
        String ask = "how are u?";
        QuestionStatus type = QuestionStatus.SUBJECTIVE;
        List<Survey> survey = surveyRepository.findByMember(1L);
        List<SubjectiveAnswer> subjectiveAnswers = new ArrayList<>();
        SubjectiveAnswer SbjAnswer = new SubjectiveAnswer();
        SbjAnswer.setAnswer("fine!");
        SubjectiveAnswer SbjAnswer2 = new SubjectiveAnswer();
        SbjAnswer2.setAnswer("good!");

        subjectiveAnswers.add(SbjAnswer);
        subjectiveAnswers.add(SbjAnswer2);

        Question question = Question.createQuestion(ask,type,survey.get(0),subjectiveAnswers,null);

        //when
        questionRepository.save(question);

        //then
        assertEquals(question,questionRepository.findOne(question.getId()));
       // SubjectiveAnswer res = questionRepository.findOne(question.getId()).getSbjAnswers().get(0);
       // System.out.println(res.getAnswer());
        // System.out.println(res.getQuestion().getQuestion());
    }


    @Test
    void objsave() {
        //(String ask, QuestionStatus type, Survey survey, List<SubjectiveAnswer> subjectiveAnswer, List<ObjectiveAnswer> objectiveAnswer)

        //given
        String ask = "what is your favorite color?";
        QuestionStatus type = QuestionStatus.OBJECTIVE;
        List<Survey> survey = surveyRepository.findByMember(1L);
        List<ObjectiveAnswer> objectiveAnswers = new ArrayList<>();
        ObjectiveAnswer objAnswer = new ObjectiveAnswer();
        objAnswer.setAnswer("blue");
        objAnswer.setCount(0);
        ObjectiveAnswer objAnswer2 = new ObjectiveAnswer();
        objAnswer2.setAnswer("red");
        objAnswer2.setCount(0);

        objectiveAnswers.add(objAnswer);
        objectiveAnswers.add(objAnswer2);

        Question question = Question.createQuestion(ask,type,survey.get(0),null,objectiveAnswers);

        //when
        questionRepository.save(question);

        //then
        assertEquals(question,questionRepository.findOne(question.getId()));

        System.out.println(questionRepository.findOne(question.getId()).getObjAnswers().get(0).getAnswer());

    }
}