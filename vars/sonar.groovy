def call(String buildStatus = 'STARTEDNEX') {
  // build status of null means successful
  
  if (buildStatus == 'STARTEDNEX') {
    color = 'BLUE'
    colorCode = '#1eaee3'
    slackSend (color: colorCode, message: summary)
  } 
  emailext (
      to: 'revathims1998@gmail.com',
      subject: subject,
      body: details,
      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
}
