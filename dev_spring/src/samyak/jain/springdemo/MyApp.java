package samyak.jain.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from the spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		//call method on  the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//call new method for fortune
		System.out.println(theCoach.getDailyFortune());
		
		//closing context
		context.close();
		
	}

}
