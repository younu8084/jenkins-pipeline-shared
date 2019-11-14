def call(String msg = 'SONAR'){
  echo "${msg}"
 
  enviroinment{
    scannerHome=tool 'sonarScanner'  
  }
  withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
}
