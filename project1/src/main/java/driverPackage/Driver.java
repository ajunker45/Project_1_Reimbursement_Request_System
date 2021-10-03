package driverPackage;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import controllers.EmployeeController;
import controllers.ReimbursementController;


public class Driver {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);
		
		
		app.after(ctx -> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");
		});
		
		app.config.addStaticFiles("/static", Location.CLASSPATH);
		
		ReimbursementController reimbursementcontroller = new ReimbursementController(app);
		//EmployeeController employeeController = new EmployeeController(app);
	}
}
