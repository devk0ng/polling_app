package com.works.polling_app.repository;

import com.works.polling_app.domain.*;
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
class SurveyRepositoryTest {
    @Autowired SurveyRepository surveyRepository;
    @Test
    void save() {
        //given
        Member member = new Member();
        member.setUserName("HongSeongBin");
        member.setPassWord("abcabcabc");

        //(Member member, Vote... votes)
        Vote v = new Vote();
        Survey survey = Survey.createSurvey(member,v);

        //when
        surveyRepository.save(survey);

        //then


    }
}