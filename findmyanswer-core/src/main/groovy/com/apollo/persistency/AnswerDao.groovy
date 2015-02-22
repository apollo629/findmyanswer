package com.apollo.persistency

import org.springframework.data.repository.CrudRepository


/**
 * Created by alpereninal on 22/02/15.
 */
interface AnswerDao extends CrudRepository<Answer,Long>{

    List<Answer> findByQuestionIdOrderByPopularityDesc(Long questionId)

    List<Answer> findByQuestionIdOrderByCreatedDesc(Long questionId)
}
