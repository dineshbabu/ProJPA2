package ch8;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Phone {

	@Id
	private int id;

	private String type;
	
	private int PhNo;
	
	@ManyToMany
	@JoinTable(name="EMP_PH", 
    joinColumns=@JoinColumn(name="EMP_ID"), 
    inverseJoinColumns=@JoinColumn(name="PH_ID")) 
	private Collection<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPhNo() {
		return PhNo;
	}

	public void setPhNo(int phNo) {
		PhNo = phNo;
	}
}

