package ch8;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="EMP_proj", 
    joinColumns=@JoinColumn(name="EMP_ID"), 
    inverseJoinColumns=@JoinColumn(name="PROJ_ID")) 
	private Collection<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

