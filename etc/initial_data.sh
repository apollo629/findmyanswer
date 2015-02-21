#!/bin/sh

curl -i -v -X POST http://localhost:8080/question -H 'Content-Type:application/json' -d '{
                                                                                                             "topic":"biology",
                                                                                                             "description" : "Question 1 about biology?"
                                                                                                         }'

curl -i -v -X POST http://localhost:8080/question -H 'Content-Type:application/json' -d '{
                                                                                                             "topic":"biology",
                                                                                                             "description" : "Question 2 about biology?"
                                                                                                         }'



curl -i -v -X POST http://localhost:8080/question -H 'Content-Type:application/json' -d '{
                                                                                                          "topic":"math",
                                                                                                          "description" : "Question 1 about math?"
                                                                                                      }'

curl -i -v -X POST http://localhost:8080/question -H 'Content-Type:application/json' -d '{
                                                                                                          "topic":"physics",
                                                                                                          "description" : "Question 1 about physics?"
                                                                                                          }'