package samyak.jain.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import samyak.jain.aopdemo.dao.AccountDAO;
import samyak.jain.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		Account myAccount=new Account();
		
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();
		
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		// close the context
		context.close();
	}
}
