package samyak.jain.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import samyak.jain.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts=new ArrayList<>();
		
		Account a1=new Account("Sam","Silver");
		Account a2=new Account("Satyam","Bronze");
		Account a3=new Account("Kushal","Gold");
		myAccounts.add(a1);
		myAccounts.add(a2);
		myAccounts.add(a3);
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass()+": Doing my DB work: Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": SetName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
}
