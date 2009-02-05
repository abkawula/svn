package beer.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beer.domain.Recipe;


@Controller
public class BrowseController {

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> showCategories() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("styles", Recipe.Style.values());
		
		return model;
		
	}
}
