package beer.web;

import java.util.HashMap;
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
import beer.domain.Clarifier;
import beer.domain.Flavoring;
import beer.domain.Hop;
import beer.domain.Recipe;
import beer.domain.SpiceHerb;
import beer.domain.Yeast;
import beer.service.IBeerService;

@Controller
public class DataController {

IBeerService beerService;
	
	@Autowired
	public void setBeerService(IBeerService beerService) {
		this.beerService = beerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Hop hop(@RequestParam(value="id", required=true) Integer id) {
		Hop hop = beerService.findHopById(id); 
		return hop;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Barley barley(@RequestParam(value="id", required=true) Integer id) {
		return beerService.findBarleyById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Yeast yeast(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findYeastById(id);
		} else {
			return new Yeast();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Additive additive(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findAdditiveById(id);
		} else {
			return new Additive();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Flavoring flavoring(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findFlavoringById(id);
		} else {
			return new Flavoring();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SpiceHerb spiceHerb(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findSpiceHerbById(id);
		} else {
			return new SpiceHerb();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Clarifier clarifier(@RequestParam(value="id", required=false) Integer id) {
		if (id != null) {
			return beerService.findClarifierById(id);
		} else {
			return new Clarifier();
		}
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
		returnMap.put("clarifiers", beerService.getAllClarifiers());
		returnMap.put("spiceHerbs", beerService.getAllSpiceHerbs());
		
		if (id != null) {
			returnMap.put("recipe", beerService.findRecipeById(id));
		} else {
			returnMap.put("recipe", new Recipe());
		}
		
		return returnMap;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRecipe(@ModelAttribute("Recipe") Recipe recipe) {
		if (recipe.isNew()) {
			beerService.persist(recipe);
		} else {
			beerService.merge(recipe);
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", recipe.getId());
		return new ModelAndView(new RedirectView("../browse/showRecipe"), model);
	}
	
}
