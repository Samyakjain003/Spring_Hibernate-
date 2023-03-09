package samyak.jain.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@After("execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----->>> Executing @After on method: "+method);
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="e")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable e) {
		
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----->>> Executing @AfterThrowing on method: "+method);
		
		System.out.println("----->>> The exception is: "+e);

	}

	@AfterReturning(
			pointcut="execution(* samyak.jain.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("----->>> Executing @AfterReturning on method: "+method);
		
		System.out.println("----->>> Result is: "+result);

		covertAccountNamesToUpperCase(result);
	}
	
	private void covertAccountNamesToUpperCase(List<Account> result) {

		for(Account a:result) {
			a.setName(a.getName().toUpperCase());
		}
		
	}

	@Before("samyak.jain.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n---->>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		//display method arguments
		
		Object[] args=theJoinPoint.getArgs();
		for(Object tempArg:args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				Account theAccount=(Account) tempArg;
				
				System.out.println("Account name: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());

			}
		}
		
	}
	
	
	
}
