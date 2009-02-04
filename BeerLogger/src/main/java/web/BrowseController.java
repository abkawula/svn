package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Recipe;

@Controller
public class BrowseController {

	@RequestMapping(method = RequestMethod.GET)
	public void showCategories() {
		System.out.println("//////////////////////////////////////////////////////");
		
	}
}
