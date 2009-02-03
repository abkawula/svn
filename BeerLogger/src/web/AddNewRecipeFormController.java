package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.BeerService;

@Controller
public class AddNewRecipeFormController {

	private BeerService beerService;

	@Autowired
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;
	}

	
	
	
	
	
	
}
