package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			Instructor theInstructor=session.get(Instructor.class, 1);
			
			Course tempCourse1=new Course("Learn Java from beginner to advanced");
			Course tempCourse2=new Course("Spring & Hibernate");
			
			theInstructor.addCourse(tempCourse1);
			theInstructor.addCourse(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
