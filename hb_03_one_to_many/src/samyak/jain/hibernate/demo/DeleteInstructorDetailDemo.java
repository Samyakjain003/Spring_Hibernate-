package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			InstructorDetail theInstructorDetail=session.get(InstructorDetail.class, 4);
			
			System.out.println(theInstructorDetail);
			System.out.println(theInstructorDetail.getInstructor());
			//remove the associated object reference
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(theInstructorDetail);
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//handle the connection leak issue
			session.close();
			factory.close();
		}
		
	}

}
