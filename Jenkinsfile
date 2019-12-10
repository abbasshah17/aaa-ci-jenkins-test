//Checking push An update number 5
pipeline {
   agent any

   stages {
      stage('pull') {
         steps {
             git 'https://github.com/abbasshah17/aaa-ci-jenkins-test'
         }
      }
      stage('clean') {
         steps {
             echo 'cleaning repo previous builds'
             sh ls
         }
      }
      stage('build') {
         steps {
             echo 'building project'
//             sh ./gradlew test
//             sh ./gradlew assembleRelease
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