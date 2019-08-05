package com.br.zup.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.Models.Winner;
import com.br.zup.Service.RandomService;
import com.br.zup.Service.WinnerService;

@Controller
public class WinnerController {

	@Autowired
	private WinnerService winnerService;

	@Autowired
	private RandomService randomService;

	@GetMapping("/")
	public ModelAndView kick(Winner winner) {
		ModelAndView modelAndView = new ModelAndView("winner.html");
		modelAndView.addObject("Winners", winnerService.showWinners());
		return modelAndView;
	}
	@PostMapping("/")
	public ModelAndView registerUser(@Valid Winner winner,BindingResult bindingWinner) {
		ModelAndView modelAndView = new ModelAndView("Winner.html");
		if(bindingWinner.hasErrors()) {
			List<String> message = new ArrayList<String>();
			for (ObjectError objError : bindingWinner.getAllErrors()){
				message.add(objError.getDefaultMessage());

			}
			modelAndView.addObject("message" ,message);
			modelAndView.addObject("Winner", winnerService.showWinners());
			return modelAndView;
		}else {
			modelAndView.addObject("message",winnerService.validateKick(winner));
		}

		modelAndView.addObject("winner",winnerService.showWinners());
		return modelAndView;

	}
}


