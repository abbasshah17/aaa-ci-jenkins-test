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
             steps {
                 echo 'running unit tests'
                 build 'DemoAppTest'
             }
         }
      }
//      stage ('instrument-tests') {
//         parallel {
//             stage ('launch-avd') {
//                 steps {
//                     build 'AVD_Job'
//                 }
//             }
//             stage ('run-instrument-tests') {
//                 steps {
//                     build job: 'DemoAppInstrumentTests', quietPeriod: 900
//                 }
//             }
//         }
///      }
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