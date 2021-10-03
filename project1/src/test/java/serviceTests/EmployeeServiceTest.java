package serviceTests;

import models.Employee;
import serviceLayer.EmployeeService;
import daos.EmployeeDao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {

	@InjectMocks
	private static EmployeeService EmployeeService;
	
	@Mock
	private static EmployeeDao Employeedao;
	
	{
		MockitoAnnotations.openMocks(this);
	
	}
	
	@BeforeClass
	public static void setUp() {
		EmployeeService = new EmployeeService();
	}
	
	@Test
	public void findSuccessfulUserTest() {
		String username = "TestUser";
		String password = "password";
		Employee testUser = new Employee(1,username,password,true);
		
		Mockito.when(Employeedao.findUser(username, password)).thenReturn(testUser);
		
		Employee ResultEmployee = EmployeeService.findUser(username, password);
		
		Assert.assertEquals(testUser, ResultEmployee);
	}
	
	@Test
	public void cantFindUserTest() {
		String username = "TestUser";
		String password = "password";
		Employee testUser = new Employee(1,username,password,true);
		
		Mockito.when(Employeedao.findUser(username, password)).thenReturn(testUser);
		
		username = "Change";
		
		Employee ResultEmployee = EmployeeService.findUser(username, password);
		
		Assert.assertEquals(null, ResultEmployee);
	}
	
	@Test
	public void FoundUserButPasswordDoesntMatchTest() {
		String username = "TestUser";
		String password = "password";
		Employee testUser = new Employee(1,username,password,true);
		
		Mockito.when(Employeedao.findUser(username, password)).thenReturn(testUser);
		
		password = "Change";
		
		Employee ResultEmployee = EmployeeService.findUser(username, password);
		
		Assert.assertEquals(null, ResultEmployee);
	}
	
}
