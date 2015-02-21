package com.apollo.persistency

import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by alpereninal on 21/02/15.
 */
@MappedSuperclass
@ToString(includeFields = true)
abstract class TimestampedEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    Date created

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    Date updated

    @PrePersist
    def void onCreate(){
        updated = created = new Date()
    }

    @PreUpdate
    def void onUpdate(){
        updated = new Date()
    }

}
