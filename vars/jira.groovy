def call(body) {
//echo "${msg}"
   def testIssue = [fields: [ project: [id: 'PRJ'],
                           summary: 'New JIRA Created from Jenkins.',
                           description: 'New JIRA Created from Jenkins.',
                           issuetype: [id: '3']]]

response = jiraNewIssue issue: testIssue, site: 'https://jira1320.atlassian.net'

echo response.successful.toString()
echo response.data.toString()
}
