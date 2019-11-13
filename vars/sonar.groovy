def call(String msg = 'Sonar Qube'){
  echo "${msg}"
  withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
}
