package samyak.jain.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		// retrieve the bean from spring container
		Coach theCoach=context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		
		boolean result= (theCoach==alphaCoach);
		
		System.out.println("Pointing to the same object:"+result);
		System.out.println("Memory loaction for the theCoach:"+theCoach);
		System.out.println("Memory location for the alphaCoach:"+alphaCoach);
		//close the context
		
		context.close();
	}

}
