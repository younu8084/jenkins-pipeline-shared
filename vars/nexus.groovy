def call(String buildStatus = 'NEXUS STAGE STARTED') {
  // build status of null means successful
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""
  
  if (buildStatus == 'NEXUS STAGE STARTED') {
    color = 'NBLUE'
    colorCode = '#032cfc'
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
