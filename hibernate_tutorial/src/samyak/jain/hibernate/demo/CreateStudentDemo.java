package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			
			//use the session object to save the java object
			
			//create a student object
			System.out.println("Creating Student Object");
			Student tempStudent=new Student("Sam","J","samyakj820@gmail.com");

			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		
	}

}
