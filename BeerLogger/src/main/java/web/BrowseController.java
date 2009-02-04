package web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import domain.Recipe;
import domain.Recipe.Style;

@Controller
public class BrowseController extends MultiActionController {

	@RequestMapping(method = RequestMethod.GET)
	public void showCategories(Model model) {
		System.out.println("//////////////////////////////////////////////////////");
		model.addAttribute("style", Recipe.Style.values());
	}
	
	
	

    

}
