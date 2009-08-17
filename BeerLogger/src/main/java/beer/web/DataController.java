package beer.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import beer.domain.Additive;
import beer.domain.Barley;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.Yeast;
import beer.service.BeerService;
import beer.service.IBeerService;

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
			Hop hop = beerService.findHopById(id); 
			return hop;
		} else {
			return new Hop();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processHop(@ModelAttribute("hop") Hop hop) {
		beerService.persist(hop);
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
	public String processYeast(@ModelAttribute("yeast") Yeast yeast) {
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
	public Map<String, Object> recipe(@RequestParam(value="id", required=false) Integer id) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("hops", beerService.getAllHops());
		returnMap.put("barlies", beerService.getAllBarlies());
		returnMap.put("yeasts", beerService.getAllYeasts());
		returnMap.put("additives", beerService.getAllAdditives());
		returnMap.put("flavorings", beerService.getAllFlavorings());
		returnMap.put("styles", Recipe.Style.values());
		
		if (id != null) {
			returnMap.put("recipe", beerService.findRecipeById(id));
		} else {
			returnMap.put("recipe", new Recipe());
		}
		
		return returnMap;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRecipe(@ModelAttribute("Recipe") Recipe recipe) {
		beerService.merge(recipe);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", recipe.getId());
		return new ModelAndView(new RedirectView("../browse/showRecipe"), model);
	}
	
}
