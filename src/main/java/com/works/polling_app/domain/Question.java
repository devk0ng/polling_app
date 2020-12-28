package com.works.polling_app.domain;

import com.works.polling_app.domain.answer.ObjectiveAnswer;
import com.works.polling_app.domain.answer.SubjectiveAnswer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "question")
    private List<SubjectiveAnswer> sbjAnswers = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<ObjectiveAnswer> objAnswers = new ArrayList<>();

    public void addSbjAnswer(SubjectiveAnswer subjectiveAnswer){
        sbjAnswers.add(subjectiveAnswer);
        subjectiveAnswer.setQuestion(this);
    }

    public void addObjAnswer(ObjectiveAnswer objectiveAnswer){
        objAnswers.add(objectiveAnswer);
        objectiveAnswer.setQuestion(this);
    }

    // 질문 생성 메서드
    public static Question createQuestion(String ask, QuestionStatus type, Survey survey){
        Question question = new Question();
        question.setQuestion(ask);
        question.setType(type);
        question.setSurvey(survey);

//        if(type == QuestionStatus.SUBJECTIVE){
//            for(SubjectiveAnswer o : subjectiveAnswer){
//                question.addSbjAnswer(o);
//            }
//        }
//        else if(type == QuestionStatus.OBJECTIVE){
//            for(ObjectiveAnswer o : objectiveAnswer){
//                question.addObjAnswer(o);
//            }
//        }


        return question;
    }
}
