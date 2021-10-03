package serviceLayer;

import java.util.List;

import daos.ReimbursementDAO;
import models.Employee;
import models.ReimbursementRequest;

public class ReimbursementService {
	private ReimbursementDAO reimbursementdao;

	public ReimbursementService() {
		this.reimbursementdao = new ReimbursementDAO();
	}
	
	public void save(ReimbursementRequest reimbursementRequest) {
		this.reimbursementdao.save(reimbursementRequest);
	}
	
	public List<ReimbursementRequest> findAllRequests() {
		return this.reimbursementdao.findAllRequests();
	}
	
	public List<ReimbursementRequest> getEmployeeReimbursementRequests(Employee employee) {
		return this.reimbursementdao.getEmployeeReimbursementRequests(employee);
	}
	
	public void updateRequestStatus(int request_id, int status_code) {
		this.reimbursementdao.updateRequestStatus(request_id, status_code);
	}
	
	public Double getReimbursementRequestsAverage() {
		return this.reimbursementdao.getReimbursementRequestsAverage();
	}
	public Double getReimbursementRequestsMax() {
		return this.reimbursementdao.getReimbursementRequestsMax();
	}
	public Double getReimbursementRequestsMin() {
		return this.reimbursementdao.getReimbursementRequestsMin();
	}
	public Double getReimbursementRequestsSum() {
		return this.reimbursementdao.getReimbursementRequestsSum();
	}
	public Long getReimbursementRequestsCount() {
		return this.reimbursementdao.getReimbursementRequestsCount();
	}
	
}
