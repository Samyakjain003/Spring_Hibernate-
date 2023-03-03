package samyak.jain.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CircketCoach: SetEmailAddress method called");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CircketCoach: SetTeam method called");
		this.team = team;
	}

	public CricketCoach() {
		System.out.println("CricketCoach: No arg constructor called");
	}
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CircketCoach: SetFortuneService method called");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		
		return "Practice batting for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		
		return "Hey cricketer, "+fortuneService.getFortune();
	}

}
