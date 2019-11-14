def mail(String mail) {
def mailRecipients="mail"
 emailext (
      to: mailRecipients,
      replyTo: mailRecipients,
      subject: subject,
      body: details,
      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
     //recipientProviders: [[$class: 'RequesterRecipientProvider']]
    )
    }
