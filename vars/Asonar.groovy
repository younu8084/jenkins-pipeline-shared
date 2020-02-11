def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
//println(jsonObj.code_quality)



	sh "curl --location --request GET 'http://3.16.33.107:9000/api/measures/component?metricKeys=vulnerabilities&component=comrades.bmi%3ABMI' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
