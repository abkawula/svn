package beer.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beer.domain.Recipe;
import beer.service.IBeerService;
import beer.service.SearchCriteria;


@Controller
public class BrowseController {

	IBeerService beerService;
	
	@Autowired
	public void setBeerService(IBeerService beerService) {
		this.beerService = beerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> showCategories() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("styles", Recipe.Style.values());
		
		return model;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showBeer(SearchCriteria searchCriteria, Model model) {
		model.addAttribute(beerService.getRecipe(searchCriteria));
		return "browse/showBeer";
	}
}
