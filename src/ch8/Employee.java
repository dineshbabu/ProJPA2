package ch8;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	private long id;
	
	private String name;
	
	@Column(name="manager")
	private String isManager = "N";
	
	private int salary;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@ManyToMany(mappedBy="employees")
	private Collection<Project> projects;
	
	@ManyToMany(mappedBy="employees")
	private Collection<Phone> phones;
	
	@ManyToOne
	@JoinColumn(name="addr_id")
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Collection getProjects() {
		return projects;
	}

	public void setProjects(Collection projects) {
		this.projects = projects;
	}

}
