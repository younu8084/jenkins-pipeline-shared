def call(String msg = 'SONAR'){
  echo "${msg}"
 
  environment{
    scannerHome=tool 'sonarScanner'  
  }
  withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
}
