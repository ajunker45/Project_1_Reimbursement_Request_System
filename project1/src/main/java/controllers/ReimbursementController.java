package controllers;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import javax.servlet.http.HttpSession;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import javassist.bytecode.stackmap.TypeData.UninitThis;
import models.Employee;
import models.ReimbursementRequest;
import serviceLayer.EmployeeService;
import serviceLayer.ReimbursementService;

public class ReimbursementController {
	private ReimbursementService reimbursementService;
	private EmployeeService employeeService;
	
	public ReimbursementController(Javalin app) {
		this.reimbursementService = new ReimbursementService();
		this.employeeService = new EmployeeService();
		
		app.routes(() -> {
			path("/ReimbursementRequest", () -> {
				path("/new", () -> {
					post(saveReimbursementRequest);
				});
				path("/update", () -> {
					post(updateRequestStatus);
				});
				path("/all", () -> {
					get(getAllReimbursementRequests);
				});
				path("/employee", ()->{
					get(getEmployeeReimbursementRequests);
				});
				path("/average", ()->{
					get(getReimbursementRequestsAverage);
				});
				path("/max", ()->{
					get(getReimbursementRequestsMax);
				});
				path("/min", ()->{
					get(getReimbursementRequestsMin);
				});
				path("/sum", ()->{
					get(getReimbursementRequestsSum);
				});
				path("/count", ()->{
					get(getReimbursementRequestsCount);
				});
			});
			path("/login",() ->{
				post(getUser);
			});
			path("/logout",() ->{
				get(revokeSession);
			});
		});
	}
	
	private Employee userEmployee;
	
	private Handler saveReimbursementRequest = ctx ->{
		//String Amount = ctx.req.getAttribute("amount");
		
		HttpSession session = ctx.req.getSession(false);
		
		if (session != null) {
			ReimbursementRequest reimbursement = new ReimbursementRequest(1,
					Double.parseDouble(ctx.req.getParameter("amount")),
					ctx.req.getParameter("reason"),
					2, // pending is 2, 1 is accepted, 0 is denied.
					userEmployee); // It might be possible to link the right employee to the request by simply having just the ID of the employee.
			
			this.reimbursementService.save(reimbursement);
		} else {
			System.out.println("You do not have a session");
		}
		
		ctx.redirect("/EmployeeReimbursement.html");
		
	};
	
	private Handler getEmployeeReimbursementRequests = ctx ->{
		ctx.json(this.reimbursementService.getEmployeeReimbursementRequests(this.userEmployee));
	};
	
	private Handler getAllReimbursementRequests = ctx ->{
		ctx.json(this.reimbursementService.findAllRequests());
	};
	
	private Handler getUser = ctx -> {
		String username = ctx.req.getParameter("username");
		String password = ctx.req.getParameter("password");
		this.userEmployee = employeeService.findUser(username, password);
		
		if (this.userEmployee == null) {
			ctx.redirect("/SignIn.html");
		} else {
			System.out.println("The Employee Is not null. You should now be granting a session");
			
			ctx.req.getSession();
			
			if (this.userEmployee.isAManager()== true) {
				
				ctx.redirect("/ManagerReimbursement.html");
				
			} else {
				
				ctx.redirect("/EmployeeReimbursement.html");
				
			}
		}
	};
	private Handler revokeSession = ctx -> {
		//If you pass in "false", an existing session is checked for.
		HttpSession session = ctx.req.getSession(false);
		if(session != null) {
			session.invalidate();
			this.userEmployee = null;
			ctx.redirect("/SignIn.html");
		}
	};
	private Handler updateRequestStatus = ctx ->{
		HttpSession session = ctx.req.getSession(false);
		
		if(session != null) {
			
			this.reimbursementService.updateRequestStatus(Integer.parseInt(ctx.req.getParameter("request_ID")), Integer.parseInt(ctx.req.getParameter("status_code")) );
			
			ctx.redirect("/ManagerReimbursement.html");
			
		} else {
			System.out.println("You do not have a session");
		}
	};
	private Handler getReimbursementRequestsAverage = ctx ->{
		ctx.json(this.reimbursementService.getReimbursementRequestsAverage());
	};
	private Handler getReimbursementRequestsMax = ctx ->{
		ctx.json(this.reimbursementService.getReimbursementRequestsMax());
	};
	private Handler getReimbursementRequestsMin = ctx ->{
		ctx.json(this.reimbursementService.getReimbursementRequestsMin());
	};
	private Handler getReimbursementRequestsSum = ctx ->{
		ctx.json(this.reimbursementService.getReimbursementRequestsSum());
	};
	private Handler getReimbursementRequestsCount = ctx ->{
		ctx.json(this.reimbursementService.getReimbursementRequestsCount());
	};
}
