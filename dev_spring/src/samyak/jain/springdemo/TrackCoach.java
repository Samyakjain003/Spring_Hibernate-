package samyak.jain.springdemo;

public class TrackCoach implements Coach{

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	@Override
	public String getDailyWorkOut() {
		
		return "Run hard 5km daily..!";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it, "+fortuneService.getFortune();
	}
	
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: doMyStartUpStuff");
	}

	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: doMyCleanUpStuff");
	}

}
