// Checking Github Web hook.

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
               steps {
                  build 'StartAppiumEmulator'
               }
            }
            stage ('ui-test') {
               steps {
                  build job: 'LoginAppTests', quietPeriod: 30
               }
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
         build 'StopAppiumEmulator'
      }
      changed {
         echo 'status changed'
      }
   }
}
