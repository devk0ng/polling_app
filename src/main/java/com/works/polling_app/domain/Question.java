package com.works.polling_app.domain;

import com.works.polling_app.domain.answer.ObjectvieAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String question;

    @Enumerated(EnumType.STRING)
    private QuestionStatus type; // 설문조사 형태 (주관식, 객관식)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToOne
    private SubjectiveAnswer subjectiveAnswer;

    @OneToMany
    private List<ObjectvieAnswer> objectvieAnswers;

    public void addObjectvieAnswer(ObjectvieAnswer objectvieAnswer){
        objectvieAnswers.add(objectvieAnswer);
        objectvieAnswer.setQuestion(this);
    }

    // 질문 생성 메서드
    public static Question createQuestion(String ask, QuestionStatus type, Survey survey, SubjectiveAnswer subjectiveAnswer, ObjectvieAnswer... objectvieAnswer){
        Question question = new Question();
        question.setQuestion(ask);
        question.setType(type);
        question.setSurvey(survey);

        if(type == QuestionStatus.SUBJECTIVE){
            question.setSubjectiveAnswer(subjectiveAnswer);
        }
        else if(type == QuestionStatus.OBJECTIVE){
            for(ObjectvieAnswer o : objectvieAnswer){
                question.addObjectvieAnswer(o);
            }
        }


        return question;
    }
}
