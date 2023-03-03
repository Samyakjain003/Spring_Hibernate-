package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Course;
import samyak.jain.hibernate.demo.entity.Instructor;
import samyak.jain.hibernate.demo.entity.InstructorDetail;
import samyak.jain.hibernate.demo.entity.Review;
import samyak.jain.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			
			Student tempStudent1=session.get(Student.class, 1);
			
			Course tempCourse1=new Course("Dock Learning");
			Course tempCourse2=new Course("Guitar Classes");
			Course tempCourse3=new Course("Learning Aptitude by CN");

			//session.save(tempStudent1);
			
			tempCourse1.addStudents(tempStudent1);
			tempCourse2.addStudents(tempStudent1);
			tempCourse3.addStudents(tempStudent1);
			
			
			//session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
