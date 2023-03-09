package samyak.jain.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import samyak.jain.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts=null;
		
		try {
			boolean tripWire=true;
			accounts=accountDAO.findAccounts(tripWire);
		}catch(Exception e) {
			System.out.println("Main Program.. Caught Exception: "+e);
		}
		
		System.out.println("Main Program: AfterThrowingDemoApp ");
		System.out.println(accounts);
		// close the context
		context.close();
	}
}
