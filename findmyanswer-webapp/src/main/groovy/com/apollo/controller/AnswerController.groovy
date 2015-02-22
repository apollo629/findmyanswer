package com.apollo.controller

import com.apollo.persistency.Answer
import com.apollo.persistency.AnswerDao
import com.apollo.persistency.QuestionDao
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by alpereninal on 22/02/15.
 */
@RestController
class AnswerController {

    def static LOGGER = LoggerFactory.getLogger AnswerController.class

    @Autowired
    AnswerDao answerDao

    @Autowired
    QuestionDao questionDao

    @RequestMapping(value = "answer/{questionId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object create(@RequestBody def json,@PathVariable("questionId") Long questionID) {
        LOGGER.debug "json: $json"
        def ds = new Answer()
        json.each { f, v ->
            ds."$f" = v
        }
        ds.question = questionDao.findOne(questionID)
        def saved = answerDao.save ds
        LOGGER.debug "saved instance: $saved"
        saved
    }

    @RequestMapping(value = "/answers/{questionId}")
    List<Map> listByTopic(@PathVariable("questionId") Long questionId) {
        def ds_list = []
        ds_list.addAll(answerDao.findByQuestionIdOrderByPopularityDesc(questionId))
        LOGGER.debug "Answers to question  $questionId : $ds_list"
        ds_list
    }


}
