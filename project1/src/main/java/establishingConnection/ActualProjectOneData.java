package establishingConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActualProjectOneData {
	public static void main (String[] args) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "Select * FROM employees";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("=================employees==================");
			while(rs.next()) {
				System.out.println("employee_id: [" +
					rs.getInt("employee_id") + 
					"]\nUsername: [" +
					rs.getString("username") + 
					"]\nPassword: [" +
					rs.getString("password") +
					"]\nManager: [" +
					rs.getBoolean("IsManager")+
					"]"
					
				);
				
				System.out.println("--------------------------------------------");	
			}
			System.out.println("============================================");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n\n");
		
		sql = "Select * FROM reimbursement_requests";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("=================Statuses==================");
			while(rs.next()) {
				System.out.println("request_id: [" +
					rs.getInt("request_id") + 
					"]\nAmount: [" +
					rs.getString("amount") + 
					"]\nReason: [" +
					rs.getString("reason") +
					"]\nRequest Owners Employee ID: [" +
					rs.getInt("employee_ID")+
					"]\nStatus: [" +
					rs.getInt("status") +
					"]"
					
				);
				
				System.out.println("--------------------------------------------");	
			}
			System.out.println("============================================");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
