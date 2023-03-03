package samyak.jain.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		// retrieve the bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkOut());
		
		//close the context
		
		context.close();
	}

}
