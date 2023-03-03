package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;
import samyak.jain.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//creating the object
			Instructor theInstructor=session.get(Instructor.class, 1);
			
			Course tempCourse1=new Course("DP series");
			//Course tempCourse2=new Course("Spring & Hibernate");
			
			
			tempCourse1.addReview(new Review("Amazing Course"));
			tempCourse1.addReview(new Review("Cool Course"));
			tempCourse1.addReview(new Review("Superb, informative"));
			tempCourse1.addReview(new Review("Instructor is good"));
			
			session.save(tempCourse1);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
