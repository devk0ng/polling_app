package com.works.polling_app.domain.answer;

import com.works.polling_app.domain.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class ObjectiveAnswer {

    @Id @GeneratedValue
    @Column(name = "objective_answer_id")
    private Long id;

    private String answer;

    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
