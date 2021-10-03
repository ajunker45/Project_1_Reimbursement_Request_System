package daos;

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

public class EmployeeDao {
	
	public Employee findUser(String username, String password) {
		
		Session session = null;
		Transaction tx = null;
		
		Employee retrievedEmployee = null;
		
		try {
			session = HibernateSessionClass.getSession();
			tx = session.beginTransaction();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			Root<Employee> root = cq.from(Employee.class);
			
			cq.select(root).where(cb.equal(root.get("username"), username));
			
			Query<Employee> query = session.createQuery(cq);
			
			retrievedEmployee = query.uniqueResult();
			
			if(retrievedEmployee != null) {
				System.out.println("We have a matching username!");
				if (!retrievedEmployee.getPassword().equals(password)) {
					retrievedEmployee = null;
					System.out.println("Passwords Didn't Match.");
				} else {
					System.out.println("Password matched!");
				}
			} else {
				System.out.println("We didnt have a matching username.");
			}
			
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return retrievedEmployee;
		
	}
}
