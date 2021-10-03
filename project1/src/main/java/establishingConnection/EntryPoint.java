package establishingConnection;

import java.sql.Statement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;




public class EntryPoint {
	
	public static void main(String[] args) {
		
		
		Connection conn = ConnectionFactory.getConnection();
		
		
		System.out.println("Printing All Customers.");
		
		String sql = "Select * FROM customers";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("=================test_table==================");
			while(rs.next()) {
				System.out.println("customer_id: ["
						+ rs.getInt("customer_id")
						+ "]  First Name: ["
						+ rs.getString("fname")
						+ "]  Last Name:  ["
						+ rs.getString("lname")
						+ "]");
			System.out.println("---------------------------------------------");
			}
			System.out.println("=============================================");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("\n\n\nPrinting all accounts.");
		
		sql = "Select * FROM accounts";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("=================test_table==================");
			while(rs.next()) {
				System.out.println("account_id: ["
						+ rs.getInt("account_id")
						+ "]  Balance: ["
						+ rs.getDouble("balance")
						+ "]  Customer ID:  ["
						+ rs.getString("customer_id")
						+ "]");
			System.out.println("---------------------------------------------");
			}
			System.out.println("=============================================");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\nPrinting all accounts only associated to a specific customer.");
		
		sql = "Select * FROM accounts WHERE customer_id = 1";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("=================test_table==================");
			while(rs.next()) {
				System.out.println("account_id: ["
						+ rs.getInt("account_id")
						+ "]  Balance: ["
						+ rs.getDouble("balance")
						+ "]  Customer ID:  ["
						+ rs.getString("customer_id")
						+ "]");
			System.out.println("---------------------------------------------");
			}
			System.out.println("=============================================");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
