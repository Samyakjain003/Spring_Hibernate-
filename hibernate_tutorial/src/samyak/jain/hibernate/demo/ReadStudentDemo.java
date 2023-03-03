package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent=new Student("Kushal","Sharma","kushal.sharma.e21@nsut.ac.in");

			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
			//now get the new session
			session=factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id primary key
			Student myStudent=session.get(Student.class, tempStudent.getId());
			//if(myStudent!=null)
			System.out.println("Get complete "+myStudent);
			//commit the transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}

}
