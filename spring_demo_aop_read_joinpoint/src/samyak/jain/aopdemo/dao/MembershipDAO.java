package samyak.jain.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		System.out.println(getClass()+": adding a membership account");
		return true;
	}
	public void goToSleep() {
		System.out.println(getClass()+": going to sleep now");

	}
}
