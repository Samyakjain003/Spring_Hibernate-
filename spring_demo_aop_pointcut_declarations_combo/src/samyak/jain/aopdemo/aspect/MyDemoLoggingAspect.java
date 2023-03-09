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
	
	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.get*(..))")
	private void getter() {}

	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	private void forDaoPackageNoGetterSetter() {}
	
//	@Before("execution( * add*())")
	
//	@Before("execution(* add*( ..))")
	
//	@Before("execution(* samyak.jain.aopdemo.dao.*.*(..))")
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n---->>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n---->>> Performing API Analytics");

	}
	
}
