def call(String buildStatus = 'DEPLOY INTO DEV ENVIROINMENT') {
  // build status of null means successful
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""
  
  if (buildStatus == 'DEPLOY INTO DEV ENVIROINMENT') {
    color = 'NIBLUE'
    colorCode = '#ed1358'
    slackSend (color: colorCode, message: summary)
  } 
  slackSend (color: colorCode, message: summary)
  emailext (
      to: 'revathims1998@gmail.com',
      subject: subject,
      body: details,
      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}
