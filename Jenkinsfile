pipeline{

    agent{
        label "master"
    }
    tools{
        maven "maven-3.8.3"
    }
    stages{
        stage("Main"){
            when{
                branch 'main'
            }
            stages{
                stage("Deploy"){
                    steps{
                        echo "deploy to production servers"
                    }
                }
            }
        }
        stage("Development"){
            when{
                branch 'development'
            }
            stages{
                stage("Package"){
                    steps{
                        sh "mvn package -Dmaven.test.skip=true"
                    }
                }
            }
        }
        stage("Pull request"){
            when{
                branch 'PR**'
            }
            stages{
                stage("Compile"){
                    steps{
                        sh "mvn clean compile"
                    }
                }
                stage("Test"){
                    steps{
                        sh "mvn test"
                    }
                    post{
                        failure{
                            mail to: "dpapanikolaou93@gmail.com",
                            subject: "Failed Test Build: $BUILD_TAG",
                            body: "Link to JOB $BUILD_URL"
                        }
                    }
                }
            }
        }  
        
    }
    post{
        always{
            junit '**/target/surefire-reports/*.xml'
        }
    }

}