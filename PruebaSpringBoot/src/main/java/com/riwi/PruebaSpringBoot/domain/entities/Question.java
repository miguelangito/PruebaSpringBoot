package com.riwi.PruebaSpringBoot.domain.entities;

import java.util.List;

import com.riwi.PruebaSpringBoot.util.enums.QuestionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "question")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private QuestionType type;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        mappedBy = "question",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false 
    )
    private List<OptionQuestion> optionQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "survey_id",
        referencedColumnName = "id"
    )
    private Survey survey;

    @Column(nullable = false)
    private boolean active;
}