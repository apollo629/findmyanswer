package com.apollo.persistency

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Created by alpereninal on 22/02/15.
 */
@Entity
@EqualsAndHashCode
@ToString(includeFields = true, includeSuper = true, includeNames = true)
@Table(name = "answer_base")
class Answer extends TimestampedEntity{

    @Id
    @GeneratedValue
    private Long Id

    @Column()
    private Integer popularity

    @NotNull
    @Column
    private String text

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question

    Question getQuestion() {
        return question
    }

    void setQuestion(Question question) {
        this.question = question
    }

    @PrePersist
    def void onCreate(){
        popularity = 0
        updated = created = new Date()
    }

    Long getId() {
        return Id
    }

    void setId(Long id) {
        Id = id
    }

    Integer getPopularity() {
        return popularity
    }

    void setPopularity(Integer popularity) {
        this.popularity = popularity
    }

    String getText() {
        return text
    }

    void setText(String text) {
        this.text = text
    }
}
