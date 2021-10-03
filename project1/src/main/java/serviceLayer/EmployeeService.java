package serviceLayer;

import daos.EmployeeDao;
import models.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	
	public EmployeeService() {
		this.employeeDao = new EmployeeDao();
	}
	
	public Employee findUser(String username,String password) {
		return this.employeeDao.findUser(username,password);
	}
}
