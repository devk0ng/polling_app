package com.works.polling_app.repository;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Survey;
import com.works.polling_app.domain.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class VoteRepositoryTest {

    @Autowired VoteRepository voteRepository;
    @Autowired SurveyRepository surveyRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    void save() {
        //given
        Vote vote = new Vote();
        Survey survey = surveyRepository.findOne(2l);
        Member member = memberRepository.findOne(1l);
        vote.setSurvey(survey);
        vote.setMember(member);

        //when
        voteRepository.save(vote);

        //then
        assertEquals(vote,voteRepository.findByMember(member).get(0));
    }

    @Test
    void findByMember() {
    }
}