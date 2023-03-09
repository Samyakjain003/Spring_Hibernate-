package samyak.jain.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	

//	@Before("execution( * add*())")
	
//	@Before("execution(* add*( ..))")
	
//	@Before("execution(* samyak.jain.aopdemo.dao.*.*(..))")
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n---->>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n---->>> Performing API Analytics");

	}
	
}
