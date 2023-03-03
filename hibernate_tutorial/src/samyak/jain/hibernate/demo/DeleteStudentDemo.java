package samyak.jain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			
			//use the session object to save the java object
			
			
			//start a transaction
			session.beginTransaction();
			
			int studentId=5;
			
			Student myStudent=session.get(Student.class,studentId);
			session.delete(myStudent);
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
		
	}

}
