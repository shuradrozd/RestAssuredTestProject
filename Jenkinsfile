pipeline {
    agent any
    tools {
        maven 'MAVEN'
        jdk 'JDK'
        allure 'ALLURE'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JENKINS_HOME = ${JENKINS_HOME}"
                '''
            }
        }

stage ('Build') {
            steps {
                 sh 'mvn clean test'
//                 echo 'test'
            }
                        post {
                            // If Maven was able to run the tests, even if some of the test
                            // failed, record the test results and archive the jar file.
                            success { allure([
                                includeProperties: true,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: '${JENKINS_HOME}/workspace/pipeAPI/target/allure-results']]
                            ])
                        }
                     }

                }
            }
            }