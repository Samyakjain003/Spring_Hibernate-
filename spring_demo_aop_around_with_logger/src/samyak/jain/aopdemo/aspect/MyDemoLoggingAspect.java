package samyak.jain.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import samyak.jain.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Around("execution(* samyak.jain.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method=proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("----->>> Executing @Around on method: "+method);
		
		long begin=System.currentTimeMillis();
		
		Object result=proceedingJoinPoint.proceed();
		
		long end=System.currentTimeMillis();
		
		long duration=end-begin;
		myLogger.info("----> Duration: "+duration/1000.0+ " seconds");
		
		return result;
	}
	
	@After("execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----->>> Executing @After on method: "+method);
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="e")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable e) {
		
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----->>> Executing @AfterThrowing on method: "+method);
		
		myLogger.info("----->>> The exception is: "+e);

	}

	@AfterReturning(
			pointcut="execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("----->>> Executing @AfterReturning on method: "+method);
		
		myLogger.info("----->>> Result is: "+result);

		covertAccountNamesToUpperCase(result);
	}
	
	private void covertAccountNamesToUpperCase(List<Account> result) {

		for(Account a:result) {
			a.setName(a.getName().toUpperCase());
		}
		
	}

	@Before("samyak.jain.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n---->>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methodSig);
		
		//display method arguments
		
		Object[] args=theJoinPoint.getArgs();
		for(Object tempArg:args) {
			myLogger.info(tempArg.toString());
			if(tempArg instanceof Account) {
				Account theAccount=(Account) tempArg;
				
				myLogger.info("Account name: "+theAccount.getName());
				myLogger.info("Account level: "+theAccount.getLevel());

			}
		}
		
	}
	
	
	
}
