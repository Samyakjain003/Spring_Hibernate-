package samyak.jain.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import samyak.jain.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts=accountDAO.findAccounts(false);
		
		System.out.println("Main Program: AfterReturningDemoApp ");
		System.out.println(accounts);
		// close the context
		context.close();
	}
}
