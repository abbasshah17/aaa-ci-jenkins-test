//Checking push An update number 5
pipeline {
   agent any

   stages {
      stage('build') {
         steps {
             ./gradlew clean
         }
         steps {
             echo 'building project'
             gradlew test
             gradlew assembleRelease
            // build job: 'AAA-JenkinsCI-Test', quietPeriod: 5
         }
      }
      
      stage ('test') {
          steps {
              echo 'testing'
          }
      }
      
      stage ('deploy') {
          steps {
              echo 'Deploying'
          }
      }
   }
}