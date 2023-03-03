package samyak.jain.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import samyak.jain.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create factory
		
		Session session=factory.getCurrentSession();
		
		try {
			
			//use the session object to save the java object
			
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			//display the students
			for(Student st:theStudents) {
				System.out.println(st);
			}
			System.out.println("ooohooo");
			theStudents=session.createQuery("from Student s where s.lastName='J'").getResultList();
			
			for(Student st:theStudents) {
				System.out.println(st);
			}
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}

}
