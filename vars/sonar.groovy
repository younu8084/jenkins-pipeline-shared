def call(body){
  enviroinment{
    scannerHome=tool 'sonarScanner'  
  }
  withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
}
