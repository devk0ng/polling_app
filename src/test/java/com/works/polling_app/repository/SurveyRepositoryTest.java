package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Survey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class SurveyRepositoryTest {

    @Autowired SurveyRepository surveyRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    void save() {
        //(Member member, Vote... votes)


        //given
        Long id = 24L; //sungbin의 id

        Member member = memberRepository.findOne(id);
        Survey survey = Survey.createSurvey(member,"what's ur name");

        //when
        surveyRepository.save(survey);

        //then
        List<Survey> res = surveyRepository.findByMember(id);

        assertEquals(survey,res.get(0));
    }


    @Test
    void findAll() {
        List<Survey> res = surveyRepository.findAll();

        for(Survey s : res){
            System.out.println(s.getStartDate());
        }

    }
}