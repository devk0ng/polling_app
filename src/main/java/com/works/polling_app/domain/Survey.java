package com.works.polling_app.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

    @Id @GeneratedValue
    @Column(name = "survey_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "survey")
    private List<Vote> votes = new ArrayList<>();

    //우선은 단방향으로 구성해보자
//    @OneToMany(mappedBy = "survey")
//    private List<Question> question;

    //생성시간
    private LocalDateTime startDate;

    //제목
    private String title;

    public void addVote(Vote vote){
        votes.add(vote);
        vote.setSurvey(this);
    }

    // 설문조사 생성 메서드
    public static Survey createSurvey(Member member, String title){
        Survey survey = new Survey();
        survey.setMember(member);

//        for(Vote v : votes){
//            survey.addVote(v);
//        }

        survey.setStartDate(LocalDateTime.now());
        survey.setTitle(title);

        return survey;
    }
}
