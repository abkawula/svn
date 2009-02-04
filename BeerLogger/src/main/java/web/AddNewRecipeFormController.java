package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.IBeerService;

@Controller
public class AddNewRecipeFormController {

	private IBeerService beerService;

	@Autowired
	public void setBeerService(IBeerService beerService) {
		this.beerService = beerService;
	}

	
	
	
	
	
	
}
