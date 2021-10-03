package daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import establishingConnection.HibernateSessionClass;
import models.Employee;
import models.ReimbursementRequest;

public class ReimbursementDAO {

	
	public void save(ReimbursementRequest reimbursementRequest) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			session.save(reimbursementRequest);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public List<ReimbursementRequest> findAllRequests(){
		List<ReimbursementRequest> reimbursementRequests = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			reimbursementRequests = session.createQuery("FROM ReimbursementRequest", ReimbursementRequest.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return reimbursementRequests;
	}
		
	public List<ReimbursementRequest> getEmployeeReimbursementRequests(Employee employee){

		List<ReimbursementRequest> reimbursementRequests = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<ReimbursementRequest> cq = cb.createQuery(ReimbursementRequest.class);
			
			Root<ReimbursementRequest> root = cq.from(ReimbursementRequest.class);
			
			cq.select(root).where(cb.equal(root.get("employee"), employee));
			
			Query<ReimbursementRequest> query = session.createQuery(cq);
			
			reimbursementRequests= query.getResultList();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		
		return reimbursementRequests;
	}
	
	public void updateRequestStatus(int request_id, int status_code) {

		Session session = null;
		Transaction tx = null;
		
		ReimbursementRequest retrievedReimbursementRequest = null;
		
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<ReimbursementRequest> cq = cb.createQuery(ReimbursementRequest.class);
			
			Root<ReimbursementRequest> root = cq.from(ReimbursementRequest.class);
			
			cq.select(root).where(cb.equal(root.get("requestID"), request_id));
			
			Query<ReimbursementRequest> query = session.createQuery(cq);
			
			retrievedReimbursementRequest = query.uniqueResult();
			
			if(retrievedReimbursementRequest != null) {
				retrievedReimbursementRequest.setStatus(status_code);
				
				session.update(retrievedReimbursementRequest);
			} else {
				System.out.println("There IS no request with that ID.");
			}
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public Double getReimbursementRequestsAverage() {
		Session session = null;
		Transaction tx = null;
		double averageAmount = 0.0;
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			averageAmount = (Double) session.createQuery("Select avg(amount) FROM ReimbursementRequest").getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return averageAmount;
	}
	
	public Double getReimbursementRequestsMax() {
		Session session = null;
		Transaction tx = null;
		double MaxAmount = 0.0;
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			MaxAmount = (Double) session.createQuery("Select max(amount) FROM ReimbursementRequest").getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return MaxAmount;
	}
	
	public Double getReimbursementRequestsMin() {
		Session session = null;
		Transaction tx = null;
		double MinAmount = 0.0;
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			MinAmount = (Double) session.createQuery("Select min(amount) FROM ReimbursementRequest").getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return MinAmount;
	}
	
	public Double getReimbursementRequestsSum() {
		Session session = null;
		Transaction tx = null;
		double SumAmount = 0.0;
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			SumAmount = (Double) session.createQuery("Select sum(amount) FROM ReimbursementRequest").getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return SumAmount;
	}
	
	public Long getReimbursementRequestsCount() {
		Session session = null;
		Transaction tx = null;
		long Count = 0;
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			Count = (Long) session.createQuery("Select count(*) FROM ReimbursementRequest").getSingleResult();
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return Count;
	}
	
}
