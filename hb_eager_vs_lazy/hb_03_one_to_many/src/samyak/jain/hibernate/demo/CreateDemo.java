package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;
import samyak.jain.hibernate.demo.entity.Student;

public class CreateDemo {

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
			
			Instructor tempInstructor= new Instructor("Anuj","Sharma","anujbhaiya@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.youtube.com/anujbhaiya","Teaching & Coding");
			
			// associating the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			// this will also save details object because of cascadetype.all
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
