def call(String msg="STAGE FAILED",String id="TEST-0")
{
 def issue = [fields: [ project: [key: 'PRO'],
                       summary: $msg,
                       description: $id,
                       issuetype: [name: 'Bug']]]
def newIssue = jiraNewIssue issue: issue, site: 'jira'
echo newIssue.data.key
 }
