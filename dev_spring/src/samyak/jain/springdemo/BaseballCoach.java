package samyak.jain.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	@Override
	public String getDailyWorkOut() {
		return "Spend 20 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
}
