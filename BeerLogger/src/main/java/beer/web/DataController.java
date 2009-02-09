package beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beer.domain.Additive;
import beer.domain.Barley;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.Yeast;
import beer.service.IBeerService;
import beer.service.RecipeForm;

@Controller
public class DataController {

IBeerService beerService;
	
	@Autowired
	public void setBeerService(IBeerService beerService) {
		this.beerService = beerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Hop hop(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findHopById(id);
		} else {
			return new Hop();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processHop(@ModelAttribute("hop") Hop hop) {
		return "browse/showCategories";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Barley barley(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findBarleyById(id);
		} else {
			return new Barley();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processBarley(@ModelAttribute("barley") Barley barley) {
		return "browse/showCategories";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Yeast yeast(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findYeastById(id);
		} else {
			return new Yeast();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processHop(@ModelAttribute("yeast") Yeast yeast) {
		return "browse/showCategories";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Additive additive(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findAdditiveById(id);
		} else {
			return new Additive();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processAdditive(@ModelAttribute("additive") Additive additive) {
		return "browse/showCategories";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Flavoring flavoring(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findFlavoringById(id);
		} else {
			return new Flavoring();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processFlavoring(@ModelAttribute("flavoring") Flavoring flavoring) {
		return "browse/showCategories";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Recipe recipe(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findRecipeById(id);
		} else {
			return new Recipe();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRecipe(@ModelAttribute("Recipe") RecipeForm recipeform) {
		return "browse/showCategories";
	}
}
