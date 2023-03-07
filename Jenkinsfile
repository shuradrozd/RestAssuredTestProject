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
//                         post {
//                             // If Maven was able to run the tests, even if some of the test
//                             // failed, record the test results and archive the jar file.
//                             success { allure([
//                                 includeProperties: true,
//                                 jdk: '',
//                                 properties: [],
//                                 reportBuildPolicy: 'ALWAYS',
//                                 results: [[path: '${JENKINS_HOME}/workspace/PipelineSRM/target/allure-results']]
//                             ])
//                         }
//                      }
post {

                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                        cucumber buildStatus: 'null',
                        customCssFiles: '',
                        customJsFiles: '',
                        failedFeaturesNumber: -1,
                        failedScenariosNumber: -1,
                        failedStepsNumber: -1,
                        fileIncludePattern: '**/*.json',
                        pendingStepsNumber: -1,
                        skippedStepsNumber: -1,
                        sortingMethod: 'ALPHABETICAL',
                        undefinedStepsNumber: -1
                }
            }
                }
            }
            }