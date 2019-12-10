//Checking push An update number 4
pipeline {
   agent any

   stages {
      stage('build') {
         steps {
             echo 'building project'
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