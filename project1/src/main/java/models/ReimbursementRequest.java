package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement_requests")
public class ReimbursementRequest {
	
	@Id
	@GeneratedValue(generator = "request_id_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(allocationSize = 1, name = "request_id_seq", sequenceName = "request_id_seq")
	@Column(name = "request_ID")
	//@SequenceGenerator(allocationSize = 1, name = "request_id_seq", sequenceName = "request_id_seq")
	
	private int requestID;
	@Column(name = "amount",precision = 2)
	private double amount;
	@Column(name = "reason", length = 230)
	private String reason;
//	@Column
//	private int employeeID; // TODO
	
	@Column(name = "status")
	private int Status;
	
	@ManyToOne
	private Employee employee;

	public ReimbursementRequest(int requestID, double amount, String reason, int status, Employee employee) {
		super();
		this.requestID = requestID;
		this.amount = amount;
		this.reason = reason;
		Status = status;
		this.employee = employee;
	}


	
	public ReimbursementRequest() {
		
	}
	
	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

//	public int getEmployeeID() {
//		return employeeID;
//	}
//
//	public void setEmployeeID(int employeeID) {
//		this.employeeID = employeeID;
//	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	@Override
	public String toString() {
		return "ReimbursementRequest [requestID=" + requestID + ", amount=" + amount + ", reason=" + reason
				+ ", Status=" + Status + ", employee=" + employee + "]";
	}
	
}
