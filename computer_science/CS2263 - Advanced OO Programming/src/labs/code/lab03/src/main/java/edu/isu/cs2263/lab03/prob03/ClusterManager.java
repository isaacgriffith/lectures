package edu.isu.cs2263.lab03.prob03;

// This code defines an API for interacting with a batch computing cluster
public interface ClusterManager {
    public int getJobCount();
    public List<JobId> getActiveJobIds();
    public JobId startJob(Job job);
    public double getJobProgress(JobId id);
    public void waitForJobToFinish(JobId id);
    public void pauseJob(JobId id);
    public void resumeJob(JobId id);
    public List<MachineId> getMachineIds();
    public MachineId getMachineIdForJob(JobId id);
    public List<JobId> getJobsOnMachine(MachineId id);
    public double getClusterLoadPercentage();
    public DiagnosticReport runClusterDiagnostics();
    public void restartCluster();
}
