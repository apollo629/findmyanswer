package com.apollo.persistency

import org.springframework.data.repository.CrudRepository

/**
 * Created by alpereninal on 21/02/15.
 */
interface QuestionDao extends CrudRepository<Question,Long> {

    List<Question> findByTopic(String topic)

    Question findTop1ByTopicOrderByCreatedDesc(String topic)

    Long countByTopic(String topic)

}