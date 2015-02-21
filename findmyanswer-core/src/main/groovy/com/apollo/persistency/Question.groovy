package com.apollo.persistency

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 * Created by alpereninal on 21/02/15.
 */
@Entity
@EqualsAndHashCode
@ToString(includeFields = true)
@Table(name = "question_base")
class Question extends TimestampedEntity{

    @Id
    @GeneratedValue
    private Long id

    @NotNull
    @Column(updatable = true, length = 75)
    private String topic

    @NotNull
    @Column(updatable = true, length = 1000)
    private String description

    @PrePersist
    def void onCreate(){
       updated = created = new Date()
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getTopic() {
        return topic
    }

    void setTopic(String topic) {
        this.topic = topic
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getAnswer() {
        return answer
    }

    void setAnswer(String answer) {
        this.answer = answer
    }
    @Column

    private String answer

}
