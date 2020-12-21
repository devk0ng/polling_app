package com.works.polling_app.domain.answer;

import com.works.polling_app.domain.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class SubjectiveAnswer {

    @Id @GeneratedValue
    @Column(name = "subjective_answer_id")
    private Long id;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

}
