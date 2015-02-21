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

    final static Logger logger = LoggerFactory.getLogger QuestionDaoTest.class


    @Test
    def void selectByTopicTest(){
        Question q1 = new Question(topic: "biology", description: "What is the substance that gives blood its color?")

        questionDao.save(q1)

        println questionDao.findByTopic("biology")
    }

}
