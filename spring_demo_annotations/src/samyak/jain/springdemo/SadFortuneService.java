package samyak.jain.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is the sad day!";
	}

}
