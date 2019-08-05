package com.br.zup.Service;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomService {

	@Autowired
	private WinnerService winnerService;
	
	public int generateRandomNumber() {
		Random random = new Random();
		int numberDrawn = random.nextInt(4);
		return numberDrawn;
	}
	
}
