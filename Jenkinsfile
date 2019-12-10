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
             sh './gradlew clean'
         }
      }
      stage ('unit-test') {
         steps {
             echo 'running unit tests'
             sh './gradlew test'
         }
      }
      stage('build') {
         steps {
             echo 'building project'
             sh './gradlew assembleRelease'
         }
      }
      
      stage ('test') {
          steps {
              echo 'testing'
          }
      }
   }

   post {
      success {
          echo 'Successful'
      }
      failure {
         echo 'failure'
      }
      unstable {
         echo 'unstable'
      }
      cleanup {
         echo 'clean up'
      }
      changed {
         echo 'status changed'
      }
   }
}