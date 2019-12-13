import hudson.model.Result
import jenkins.model.CauseOfInterruption

//iterate through current project runs
build.getProject()._getRuns().iterator().each{ run ->
  def exec = run.getExecutor()
  //if the run is not a current build and it has executor (running) then stop it
  if( run!=build && exec!=null ){
    //prepare the cause of interruption
    def cause = { "interrupted by build #${build.getId()}" as String } as CauseOfInterruption 
    exec.interrupt(Result.ABORTED, cause)
  }
}
