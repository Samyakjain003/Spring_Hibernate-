package samyak.jain.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String data[]= {"Beware of the wolf in the ship's clothing",
			"Diligence is the mother of good luck",
			"The journey is the rewarded"};
	
	Random myRandom=new Random();
	@Override
	public String getFortune() {
		
		int index=myRandom.nextInt(data.length);
		
		return data[index];
	}

}
