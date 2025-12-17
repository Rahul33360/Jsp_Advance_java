package oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	String name;
	@Id
	@GeneratedValue
	int id;

	@OneToMany
	List<Product> p = new ArrayList<Product>();

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

	public List<Product> getP() {
		return p;
	}

	public void setP(List<Product> p) {
		this.p = p;
	}

}
