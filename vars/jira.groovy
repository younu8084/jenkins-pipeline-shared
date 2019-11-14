def call(String msg="STAGE FAILED",String id="TEST-0")
{
  $echo "${msg}"
  jiraAddComment comment: msg, idOrKey:id , site: 'jira'
 }
