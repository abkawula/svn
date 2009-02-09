package beer.service;

import java.util.List;

import beer.domain.Hop;
import beer.domain.Recipe;


public interface IBeerService {

	List<Recipe> getRecipe(SearchCriteria searchCriteria);
	Hop findHopById(Integer id);
}
