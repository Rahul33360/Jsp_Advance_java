package ManyToOne;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departmentee {
	@Id
	String Dname;
	int dId;

	@OneToMany
	List<Employee> employee = new ArrayList<Employee>();
	
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public int getDid() {
		return dId;
	}
	public void setDid(int did) {
		this.dId = did;
	}
	
}
