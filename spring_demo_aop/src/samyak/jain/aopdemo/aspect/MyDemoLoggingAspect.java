package samyak.jain.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	//start with @Before advice
//	@Before("execution( * add*())")
	
//	@Before("execution(* add*( ..))")
	
	@Before("execution(* samyak.jain.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n---->>> Executing @Before advice on add*() method");
	}
}
