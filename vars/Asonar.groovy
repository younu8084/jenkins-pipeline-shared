def call(){
  
sh 'curl -X GET -u admin:admin http://3.16.33.107:9000/api/measures/component?component=comrades.bmi%3ABMI&metricKeys=vulnerabilities '
}
