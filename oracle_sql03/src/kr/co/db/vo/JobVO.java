package kr.co.db.vo;

import java.util.Objects;

public class JobVO {
	
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public int getMinSalary() {
		return minSalary;
	}
	
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	
	public int getMaxSalary() {
		return maxSalary;
	}
	
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(jobId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobVO other = (JobVO) obj;
		return Objects.equals(jobId, other.jobId);
	}
	
	@Override
	public String toString() {
		return "JobVO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}
	
}
