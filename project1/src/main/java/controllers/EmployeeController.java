package controllers;

import io.javalin.Javalin;
import serviceLayer.EmployeeService;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import io.javalin.http.Handler;

public class EmployeeController {
	private EmployeeService employeeService;
	
	
	public EmployeeController(Javalin app) {
		this.employeeService = new EmployeeService();
		app.routes(() ->{
			path("/login",() ->{
				post(getUser);
				
			});
		});
	}
	
	private Handler getUser = ctx -> {
		System.out.println(ctx.req.getParameter("username"));
		System.out.println(ctx.req.getParameter("password"));
	};
}
