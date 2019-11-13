def call(String msg = 'Sonar Qube'){
  echo "${msg}"
  enviroinment{
    scannerHome=tool 'sonarScanner'  
  }
  withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
}
