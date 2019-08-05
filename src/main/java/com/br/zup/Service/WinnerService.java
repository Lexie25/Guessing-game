package com.br.zup.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.Models.Winner;
import com.br.zup.Repositories.WinnerRepository;

@Service
public class WinnerService {

	@Autowired
	private WinnerRepository winnerRepository;

	@Autowired
	private RandomService randomService;

	public Iterable<Winner>showWinners(){
		return winnerRepository.findAll();
	}

	public String validateKick(Winner winner){
		if(winner.getKick()== randomService.generateRandomNumber()) {
			winnerRepository.save(winner);
			return "You're right";
		}else {
			return "You missed another number was drawn";
		}
	}
}


