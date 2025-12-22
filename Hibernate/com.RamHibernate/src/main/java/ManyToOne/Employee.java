package ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Employee {
	String name;
	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne
	Departmentee d;
	
	public Departmentee getD() {
		return d;
	}
	public void setD(Departmentee d) {
		this.d = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
