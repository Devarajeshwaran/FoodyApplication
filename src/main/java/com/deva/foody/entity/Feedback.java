package com.deva.foody.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(name = "subject")
    private String subject;

    @NotBlank
    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Member member;
}
