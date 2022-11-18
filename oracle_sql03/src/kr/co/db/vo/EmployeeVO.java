package kr.co.db.vo;

import java.sql.Date;
import java.util.Objects;

/**
 * VO 객체
 *    Value Object 로써 데이터 베이스 테이블의 Record 값을 저장 하기 위한
 *    용도로 사용한다.(데이터 저장용 객체이다.)
 * @author user1
 *
 */
public class EmployeeVO {

	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double commission;
	private int managerId;
	private int deptId;
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = new Date(hireDate.getTime());
	}
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public int getManagerId() {
		return managerId;
	}
	
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public String toString() {
		return "EmployeeVO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return empId == other.empId;
	}
	
}
