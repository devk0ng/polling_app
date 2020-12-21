package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Survey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class SurveyRepositoryTest {

    @Autowired SurveyRepository surveyRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    void save() {
        Survey survey = new Survey();

        Long id = 1L; //sungbin의 id

        Member member = memberRepository.findOne(id);



    }

    @Test
    void findByMember() {
    }

    @Test
    void findAll() {
    }
}