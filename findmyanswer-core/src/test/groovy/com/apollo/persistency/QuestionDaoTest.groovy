package com.apollo.persistency

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * Created by alpereninal on 21/02/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["/spring/context-persistency.xml"])
class QuestionDaoTest {

    @Autowired
    QuestionDao questionDao

    @Autowired
    AnswerDao answerDao

    final static Logger logger = LoggerFactory.getLogger QuestionDaoTest.class


    @Test
    def void selectByTopicTest(){
        Question q1 = new Question(topic: "biology", description: "What is the substance that gives blood its color?")
        Question q2 = new Question(topic: "biology", description: "Is is second biology question?")

        questionDao.save q1
        questionDao.save q2

        println questionDao.countByTopic("biology")

        questionDao.findByTopic("biology").each {
            println it
        }
    }


    @Test
    def void questionAnswerTest(){
        Question q1 = new Question(topic: "biology", description: "What is the substance that gives blood its color?")
        def saved_q1 = questionDao.save q1

        Question q2 = new Question(topic: "math", description: "Is it a math question?")
        def saved_q2 = questionDao.save q2

        Answer a1 = new Answer(text: "Answer 1 to Biology question", question:saved_q1)
        Answer a2 = new Answer(text: "Answer 2 to Biology question", question:saved_q1)
        Answer a3 = new Answer(text: "Answer to Math question", question:saved_q2)
        def saved_a1 = answerDao.save a1
        saved_a1.setPopularity(5)
        answerDao.save saved_a1
        def saved_a2 = answerDao.save a2
        def saved_a3 = answerDao.save a3

        logger.info("Find all questions")
        questionDao.findAll().each {
            println it
        }

        println "**********************"
        logger.info("Find all answers")
        answerDao.findAll().each {
            println it
        }
        println "**********************"
        logger.info("Find all answers to specific question")


        answerDao.findByQuestionIdOrderByPopularityDesc(saved_q1.id).each {
            println it
        }

    }


}
