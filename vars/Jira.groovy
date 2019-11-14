def call(String msg="STAGE FAILED",String id="TEST-0")
{
  jiraAddComment comment: msg, idOrKey:id , site: 'jira'
 }
