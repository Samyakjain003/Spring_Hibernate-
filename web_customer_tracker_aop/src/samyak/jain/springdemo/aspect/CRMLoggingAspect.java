package samyak.jain.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	
	@Pointcut("execution(* samyak.jain.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* samyak.jain.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* samyak.jain.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() ||forDaoPackage()")
	private void forAppFlow() {}
	
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		String theMethod=joinPoint.getSignature().toShortString();
		myLogger.info("---->> In @Before: calling method: "+theMethod);
		
		Object[] args=joinPoint.getArgs();
		
		for(Object temp:args) {
			myLogger.info("---->> Argument: "+args);
		}
		
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		
		String theMethod=joinPoint.getSignature().toShortString();
		myLogger.info("---->> In @AfterReturning: from method: "+theMethod);
		
		myLogger.info("---->> Result: "+theResult);
		
	}
}
