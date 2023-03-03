package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			//creating the object
			
			Instructor tempInstructor= new Instructor("Alakh","Pandey","physciswallah@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.youtube.com/physicswallah","Teaching");
			
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
			session.close();
			factory.close();
		}
		
	}

}
