package samyak.jain.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Hey! Today is your lucky day..";
		
	}

}
