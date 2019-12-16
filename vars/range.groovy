import jenkins.model.*;
import hudson.model.Fingerprint.RangeSet;
def call(body) {
 def jobName = "${env.JOB_NAME}"

def j = jenkins.model.Jenkins.instance.getItem(jobName);

def r = RangeSet.fromString(buildRange, true);

j.getBuilds(r).each { it.delete() }
}
