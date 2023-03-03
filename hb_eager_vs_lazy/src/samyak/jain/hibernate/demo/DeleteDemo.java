package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;
import samyak.jain.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			//creating the object
			
			session.beginTransaction();
			
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			if(tempInstructor!=null) {
				session.delete(tempInstructor);
			}
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
