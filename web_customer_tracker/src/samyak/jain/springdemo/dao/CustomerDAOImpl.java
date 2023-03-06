package samyak.jain.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import samyak.jain.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the hibernate session
		Session currSession=sessionFactory.getCurrentSession();
		//create query
		// sorting by first name
		Query<Customer> query=currSession.createQuery("from Customer order by firstName",Customer.class);
		//get the result result from the query
		List<Customer> result=query.getResultList();
		//return the result
		return result;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currSession=sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(theCustomer);
	}



	@Override
	public Customer getCustomer(int theId) {
		Session currSession=sessionFactory.getCurrentSession();
		Customer customer=currSession.get(Customer.class, theId);
		return customer;
	}



	@Override
	public void deleteCustomer(int theId) {
		Session currSession=sessionFactory.getCurrentSession();
		Query theQuery=currSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
