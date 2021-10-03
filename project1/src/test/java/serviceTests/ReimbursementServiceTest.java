package serviceTests;

import java.util.Arrays;
import java.util.List;

import models.Employee;
import models.ReimbursementRequest;
import serviceLayer.ReimbursementService;
import daos.ReimbursementDAO;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class ReimbursementServiceTest {

	@InjectMocks
	private static ReimbursementService reimbursementService;
	
	@Mock
	private static ReimbursementDAO reimbursementdao;
	
	{
		MockitoAnnotations.openMocks(this);
	
	}
	
	@BeforeClass
	public static void setUp() {
		reimbursementService = new ReimbursementService();
	}
	
	
	
	
	@Test
	public void testFindAllRequests(){
		Mockito.when(reimbursementdao.findAllRequests()).thenReturn(
				Arrays.asList(
						new ReimbursementRequest(1, 100.00, "A reason", 2, new Employee( 1,"TestUser","TestPassword",true)),
						new ReimbursementRequest(2, 200.20, "A reason 3", 2, new Employee( 2,"TestUser2","TestPsword",false)),
						new ReimbursementRequest(3, 1.00, "A reason 2", 1, new Employee( 3,"TestUser3","TestPassd",false)),
						new ReimbursementRequest(4, 400.00, "A reason 4", 0, new Employee( 4,"TestUser4","TtPassword",false))
						)
				);
		
		List<ReimbursementRequest> reimbursementRequests = reimbursementService.findAllRequests();
		
		Assert.assertEquals("The list should have 4 Requests inside of it.", 4, reimbursementRequests.size());
		
	}
	
	@Test
	public void testGetEmployeeReimbursementRequests(){
		Employee testEmployee = new Employee( 1,"TestUser","TestPassword",false);
		
		Mockito.when(reimbursementdao.getEmployeeReimbursementRequests(testEmployee)).thenReturn(
				Arrays.asList(
						new ReimbursementRequest(1, 300.00, "A reason 5", 2, testEmployee),
						new ReimbursementRequest(2, 100.20, "A reason 6", 2, testEmployee),
						new ReimbursementRequest(3, 234.00, "A reason 7", 1, testEmployee),
						new ReimbursementRequest(4, 198.00, "A reason 8", 0, testEmployee)
						)
				);
		
		List<ReimbursementRequest> reimbursementRequests = reimbursementService.getEmployeeReimbursementRequests(testEmployee);
		
		Assert.assertEquals("The list should have 4 Requests inside of it.", 4, reimbursementRequests.size());
		
	}
	
	@Test
	public void testGetReimbursementRequestsSum() {
		Mockito.when(reimbursementdao.getReimbursementRequestsSum()).thenReturn(245.26);
		
		Double RequestSum = reimbursementService.getReimbursementRequestsSum();
		Assert.assertEquals(245.26, RequestSum, 0);
	}
	@Test
	public void testGetReimbursementRequestsAverage() {
		Mockito.when(reimbursementdao.getReimbursementRequestsAverage()).thenReturn(14.30);
		
		Double RequestAverage = reimbursementService.getReimbursementRequestsAverage();
		Assert.assertEquals(14.30, RequestAverage, 0);
	}
	@Test
	public void testGetReimbursementRequestsMax() {
		Mockito.when(reimbursementdao.getReimbursementRequestsMax()).thenReturn(123414.30);
		
		Double RequestMax = reimbursementService.getReimbursementRequestsMax();
		Assert.assertEquals(123414.30, RequestMax, 0);
	}
	@Test
	public void testGetReimbursementRequestsMin() {
		Mockito.when(reimbursementdao.getReimbursementRequestsMin()).thenReturn(2.40);
		
		Double RequestMin = reimbursementService.getReimbursementRequestsMin();
		Assert.assertEquals(2.40, RequestMin, 0);
	}
	@Test
	public void testGetReimbursementRequestsCount() {
		long test = 1251234;
		Mockito.when(reimbursementdao.getReimbursementRequestsCount()).thenReturn(test);
		
		long RequestCount = reimbursementService.getReimbursementRequestsCount();
		Assert.assertEquals(1251234, RequestCount);
		
	}
	
	
}
