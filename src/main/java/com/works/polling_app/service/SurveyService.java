package com.works.polling_app.service;

import com.works.polling_app.domain.Member;
import com.works.polling_app.domain.Question;
import com.works.polling_app.domain.Survey;
import com.works.polling_app.domain.Vote;
import com.works.polling_app.domain.answer.ObjectiveAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import com.works.polling_app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final VoteRepository voteRepository;

  //  private final ObjectiveAnswerRepository objectiveAnswerRepository;
  //  private final SubjectiveAnswer subjectiveAnswer;

    //설문 생성   Member member, String title
    @Transactional
    public Long makeSurvey(Long memberId, String title, List<Question> questionList){
        Member member = memberRepository.findOne(memberId);

        Survey survey = Survey.createSurvey(member,title);

        surveyRepository.save(survey);

        for(Question q : questionList){
            q.setSurvey(survey);
            questionRepository.save(q);
        }

        return survey.getId();
    }

    //설문목록 전체 조회
    public List<Survey> findSurveys(){
        return surveyRepository.findAll();
    }

    //자신이 생성한 설문목록 조회
    public List<Survey> findSurveyByMake(Long memberId){
        return surveyRepository.findByMember(memberId);
    }

    //자신이 투표한 설문목록 조회
    public List<Survey> findSurveyByVote(Long memberId){
        Member member = memberRepository.findOne(memberId);
        List<Vote> votes = voteRepository.findByMember(member);

        List<Survey> results = new ArrayList<>();

        for(Vote v : votes){
            results.add(v.getSurvey());
        }

        return results;
    }

    //설문투표
//    public Survey voteSurvey(){
//
//    }



}
