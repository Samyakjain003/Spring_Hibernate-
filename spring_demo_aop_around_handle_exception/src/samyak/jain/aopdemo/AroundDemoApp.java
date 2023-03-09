package samyak.jain.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import samyak.jain.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		TrafficFortuneService fortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDempApp");
		
		System.out.println("Calling getFortune");
		
		String data=fortuneService.getFortune();
		
		System.out.println("My fortune is: "+data);
		// close the context
		context.close();
	}
}
