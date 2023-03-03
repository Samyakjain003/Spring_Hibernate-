package samyak.jain.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService){
//		this.fortuneService=fortuneService;
//	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Do my startup Stuff: TennisCoach");
	}
	
	@PreDestroy
	public void doMyCleanupStudd() {
		System.out.println("Do my clean Up Stuff: TennisCoach");
	}
	
	public TennisCoach() {
		System.out.println("Construct Called: TennisCoach"); 
	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Method Called: TennisCoach"); 
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
		
	}
	
	

}
