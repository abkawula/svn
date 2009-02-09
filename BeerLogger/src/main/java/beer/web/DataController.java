package beer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beer.domain.Hop;
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
			return beerService.findHopById(id);
		} else {
			return new Hop();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processHop(@ModelAttribute("hop") Hop hop) {
		return "browse/showCategories";
	}
	
}
