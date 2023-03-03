package samyak.jain.hibernate.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//creating the object
			int theId=1;
			
			Query<Instructor> query=session.createQuery("select i from Instructor i "
											+"JOIN FETCH i.courses "
											+"where i.id=:instructorId");
			query.setParameter("instructorId", theId);
			
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("--> "+ tempInstructor );
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println(" Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
