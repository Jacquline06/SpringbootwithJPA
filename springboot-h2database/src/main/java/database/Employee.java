package database;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAIL")
public class Employee {
@Id
@Column(name="EmployeeId")
private Long empid;
@Column(name="EmployeeName")
private String empname;
@Column(name="EmployeeDep")
private String empdep;

public Long getEmpid() {
	return empid;
}
public void setEmpid(Long empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpdep() {
	return empdep;
}
public void setEmpdep(String empdep) {
	this.empdep = empdep;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", empdep=" + empdep + "]";
}

}
