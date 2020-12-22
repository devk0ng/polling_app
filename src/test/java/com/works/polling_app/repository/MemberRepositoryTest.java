package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Survey;
import com.works.polling_app.domain.Vote;
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
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    void save() {
        //given
        Member member = new Member();
//        Survey survey1 = new Survey();
//        Survey survey2 = new Survey();

        List<Survey> surveyList = new ArrayList<>();

//        survey1.setStartDate("12/13");
//        survey2.setStartDate("1/3");
//        surveyList.add(survey1);
//        surveyList.add(survey2);

        Vote vote = new Vote();
        List<Vote> voteList = new ArrayList<>();
        voteList.add(vote);

        member.setUserName("alex");
        member.setPassWord("321");
        member.setSurveys(surveyList);
        member.setVotes(voteList);

        //when
        memberRepository.save(member);

        //then
        assertEquals(member,memberRepository.findOne(member.getId()));
        List<Survey> res = memberRepository.findOne(member.getId()).getSurveys();
        System.out.println("res:"+res);
    }
}