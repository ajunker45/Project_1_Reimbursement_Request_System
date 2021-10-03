package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	// Id denotes a PK
	@Column(name = "employee_ID")

	@GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO)

	@SequenceGenerator(allocationSize = 1, name = "employee_id_seq", sequenceName = "employee_id_seq")
	private int employeeID;

	@Column(name = "username", length = 30)
	private String username;

	@Column(name = "password", length = 30)
	private String password;

	@Column(name = "IsManager")
	private boolean isAManager;

	public Employee() {

	}
	
	
	
	public Employee(int employeeID, String username, String password, boolean isAManager) {
		super();
		this.employeeID = employeeID;
		this.username = username;
		this.password = password;
		this.isAManager = isAManager;
	}



	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAManager() {
		return isAManager;
	}

	public void setAManager(boolean isAManager) {
		this.isAManager = isAManager;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", username=" + username + ", password=" + password
				+ ", isAManager=" + isAManager + "]";
	}
	
	
}
