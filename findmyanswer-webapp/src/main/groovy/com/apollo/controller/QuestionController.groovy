package com.apollo.controller

import com.apollo.persistency.Question
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
 * Created by alpereninal on 21/02/15.
 */

@RestController
class QuestionController {

    def static LOGGER = LoggerFactory.getLogger QuestionController.class

    @Autowired
    QuestionDao questionDao

    @RequestMapping(value = "question", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Object create(@RequestBody def json) {
        LOGGER.debug "json: $json"
        def ds = new Question()
        json.each { f, v ->
            ds."$f" = v
        }
        def saved = questionDao.save ds
        LOGGER.debug "saved instance: $saved"
        saved
    }

    @RequestMapping(value = "/questions")
    List<Map> list() {
        def ds_list = []
        ds_list.addAll(questionDao.findAll())
        LOGGER.debug "questions: $ds_list"
        ds_list
    }

    @RequestMapping(value = "/questions/{topic}")
    List<Map> listByTopic(@PathVariable("topic") String topic) {
        def ds_list = []
        ds_list.addAll(questionDao.findByTopic(topic))
        LOGGER.debug "questions: $ds_list"
        ds_list
    }

}
