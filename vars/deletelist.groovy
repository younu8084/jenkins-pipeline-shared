import jenkins.model.Jenkins
import hudson.model.Job
import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject

//Input:
//If dryRun is true, will print list of jobs that would be included in the deletion
def dryRun = true

Jenkins.get().getAllItems(WorkflowMultiBranchProject.class).each { WorkflowMultiBranchProject job ->
  if (dryRun) {
      println "${job.free1} will be removed."
  } 
}
return
