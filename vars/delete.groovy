import jenkins.model.Jenkins
import hudson.model.Job
import hudson.model.FreeStyleProject
import org.jenkinsci.plugins.workflow.job.WorkflowJob

//Inputs:

//If dryRun is true, will print list of jobs that would be included in the deletion
def dryRun = true

//Copy one of these Job Types available for deletion: FreeStyleProject, WorkflowJob
def jobDeleteType = JOB_TYPE


//Script:
Jenkins.instance.getAllItems(Job.class)
        .findAll { Job job -> (job in jobDeleteType) }
        .each { Job job ->
            def jobName = "${jobDeleteType} Job Name: ${job.fullName}"
            if (dryRun) {
                println "${jobName} will be removed."
            } else {
                job.delete()
                println "${jobName} has been removed."
            }
        }
return
