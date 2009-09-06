package beer.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beer.domain.AdditiveIngredient;
import beer.domain.BarleyIngredient;
import beer.domain.FlavoringIngredient;
import beer.domain.HopIngredient;
import beer.domain.Recipe;
import beer.domain.YeastIngredient;
import beer.service.IBeerService;
import beer.service.SearchCriteria;


@Controller
public class BrowseController {
	
	private static final Logger log = Logger.getLogger(BrowseController.class);

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
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> hop() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("hops", beerService.getAllHops());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> barley() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("barlies", beerService.getAllBarlies());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> yeast() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("yeasts", beerService.getAllYeasts());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> additive() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("additives", beerService.getAllAdditives());
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> flavoring() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("flavorings", beerService.getAllFlavorings());
		return model;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> showRecipe(@RequestParam(value="id") Integer id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		Recipe r = beerService.findRecipeById(id);
		returnMap.put("recipe", r);
		
		returnMap.put("barleyMap", getBarleyMap(r));
		returnMap.put("hopMap", getHopMap(r));
		returnMap.put("yeastMap", getYeastMap(r));
		returnMap.put("flavoringMap", getFlavoringMap(r));
		returnMap.put("additiveMap", getAdditiveMap(r));
		returnMap.put("testString", "Adam Rules");
		
		
		
		return returnMap;
	}
	
	private Map<String, Double> getBarleyMap(Recipe r) {
		Map<String, Double> barleyMap = new HashMap<String, Double>();
		for (BarleyIngredient b : r.getBarlies()) {
			String name = b.getBarley().getVariety();
			if (barleyMap.get(name) != null) {
				barleyMap.put(name, barleyMap.get(name).doubleValue() + b.getQuantity());
			} else {
				barleyMap.put(name, b.getQuantity());
			}
		}
		return barleyMap;
	}
	
	private Map<String, Double> getHopMap(Recipe r) {
		Map<String, Double> hopMap = new HashMap<String, Double>();
		for (HopIngredient h : r.getHops()) {
			String name = h.getHop().getName();
			if (hopMap.get(name) != null) {
				hopMap.put(name, hopMap.get(name).doubleValue() + h.getQuantity());
			} else {
				hopMap.put(name, h.getQuantity());
			}
		}
		return hopMap;
	}
	
	private Map<String, Double> getYeastMap(Recipe r) {
		Map<String, Double> yeastMap = new HashMap<String, Double>();
		for (YeastIngredient y : r.getYeasts()) {
			String name = y.getYeast().getName();
			if (yeastMap.get(name) != null) {
				yeastMap.put(name, yeastMap.get(name).doubleValue() + y.getQuantity());
			} else {
				yeastMap.put(name, y.getQuantity());
			}
		}
		return yeastMap;
	}
	
	private Map<String, Double> getAdditiveMap(Recipe r) {
		Map<String, Double> additiveMap = new HashMap<String, Double>();
		for (AdditiveIngredient a : r.getAdditives()) {
			String name = a.getAdditive().getName();
			if (additiveMap.get(name) != null) {
				additiveMap.put(name, additiveMap.get(name).doubleValue() + a.getQuantity());
			} else {
				additiveMap.put(name, a.getQuantity());
			}
		}
		return additiveMap;
	}
	
	private Map<String, Double> getFlavoringMap(Recipe r) {
		Map<String, Double> flavoringMap = new HashMap<String, Double>();
		for (FlavoringIngredient f : r.getFlavorings()) {
			String name = f.getFlavoring().getName();
			if (flavoringMap.get(name) != null) {
				flavoringMap.put(name, flavoringMap.get(name).doubleValue() + f.getQuantity());
			} else {
				flavoringMap.put(name, f.getQuantity());
			}
		}
		return flavoringMap;
	}
	
}