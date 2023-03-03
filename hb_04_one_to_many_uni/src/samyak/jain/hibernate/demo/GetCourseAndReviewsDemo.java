package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;
import samyak.jain.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

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
			
			Course course=session.get(Course.class,11);
			
			System.out.println(course);
			System.out.println(course.getReviews());
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
