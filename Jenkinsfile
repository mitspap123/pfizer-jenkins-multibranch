pipeline{

    agent{
        label "master"
    }
    tools{
        maven "maven-3.8.3"
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
        stage("Package"){
            steps{
                sh "mvn package -Dmaven.test.skip=true"
            }
        }
    }
    post{
        always{
            junit '**/target/surefire-reports/*.xml'
        }
    }


}