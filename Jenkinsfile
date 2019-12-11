//Checking push An update number 5
pipeline {
   agent any

   stages {
      stage('build') {
         steps {
             build 'DemoAppBuild'
         }
      }
      stage ('unit-test') {
         steps {
             echo 'running unit tests'
             build 'DemoAppTest'
         }
      }
      stage ('instrument-tests') {
         parallel {
             stage ('launch-avd') {
                 build 'AVD_Job'
             }
             stage ('run-instrument-tests') {
                 build 'DemoAppInstrumentTests'
             }
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